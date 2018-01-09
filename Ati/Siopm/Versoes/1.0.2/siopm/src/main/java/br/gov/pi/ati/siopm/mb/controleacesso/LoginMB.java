package br.gov.pi.ati.siopm.mb.controleacesso;

import br.gov.pi.ati.siopm.bo.cadastro.OrganizacaoBO;
import br.gov.pi.ati.siopm.bo.controleacesso.AcessoSistemaBO;
import br.gov.pi.ati.siopm.bo.controleacesso.PerfilBO;
import br.gov.pi.ati.siopm.dao.controleacesso.UsuarioDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import br.gov.pi.ati.siopm.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.siopm.modelo.controleacesso.Perfil;
import br.gov.pi.ati.siopm.modelo.controleacesso.Usuario;
import br.gov.pi.ati.siopm.util.Utils;
import com.xpert.i18n.I18N;
import com.xpert.persistence.query.Restrictions;
import com.xpert.security.ActiveDirectory;
import com.xpert.security.bean.SecurityLoginBean;
import com.xpert.security.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.naming.AuthenticationException;
import javax.naming.CommunicationException;
import javax.naming.NamingException;
import javax.naming.ldap.LdapContext;
import javax.persistence.EntityManager;

/**
 *
 * @author Ayslan
 */
@ManagedBean
@ViewScoped
public class LoginMB extends SecurityLoginBean {

    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private PerfilBO perfilBO;
    @EJB
    private AcessoSistemaBO acessoSistemaBO;
    @EJB
    private OrganizacaoBO organizacaoBO;

    private Perfil perfil = new Perfil();

    @ManagedProperty(value = "#{sessaoUsuarioMB}")
    private SessaoUsuarioMB sessaoUsuarioMB;
    private static final Logger logger = Logger.getLogger(LoginMB.class.getName());
    private List<Organizacao> organizacoes;
    private List<Organizacao> opms = new ArrayList<Organizacao>();
    private List<Organizacao> apoios = new ArrayList<Organizacao>();
    private boolean mostrarOpm = false;
    private boolean mostrarApoio = false;

    @PostConstruct
    public void init() {

        List<Organizacao> organizacoesTemp = organizacaoBO.getDAO().list("ativo", true);
        for (Organizacao org : organizacoesTemp) {
            if (org instanceof Opm) {
                opms.add(org);
            } else {
                apoios.add(org);
            }
        }
    }

    @Override
    public void login() {
        super.login();
    }

    @Override
    public String getRedirectPageWhenSucess() {
        return "/view/home.jsf";
    }

    @Override
    public String getRedirectPageWhenLogout() {
        return "/index.jsf";
    }

    @Override
    public String getUserNotFoundMessage() {
        return I18N.get("business.usuarioOuSenhaInvalidos");
    }

    @Override
    public String getInactiveUserMessage() {
        return I18N.get("business.usuarioInativo");
    }

    @Override
    public EntityManager getEntityManager() {
        return usuarioDAO.getEntityManager();

    }

    @Override
    public boolean isLoginUpperCase() {
        return true;
    }

    @Override
    public boolean isValidateWhenNoRolesFound() {
        return false;
    }

    /**
     * Registrar o acesso do usuario atraves da classe AcessoSistema
     *
     * @see AcessoSistema
     * @param user
     */
    @Override
    public void onSucess(User user) {
        Usuario usuario = (Usuario) user;
        usuario.setOrganizacoes(organizacoes);
        setUserPassword(null);

        List<Perfil> perfisTemp = new ArrayList<Perfil>();
        perfisTemp.add(perfil);
        usuario.setPerfis(perfisTemp);

        acessoSistemaBO.save(usuario);
        usuarioDAO.saveOrMerge(usuario, true);
        getUserSession().createSession();
    }

    @Override
    public Class getUserClass() {
        return Usuario.class;
    }

    @Override
    public SessaoUsuarioMB getUserSession() {
        return getSessaoUsuarioMB();
    }

    public SessaoUsuarioMB getSessaoUsuarioMB() {
        return sessaoUsuarioMB;
    }

    public void setSessaoUsuarioMB(SessaoUsuarioMB sessaoUsuarioMB) {
        this.sessaoUsuarioMB = sessaoUsuarioMB;
    }

    @Override
    public User authenticateUserPassword(User user, String password) {
        //se nao for LDAP
        Usuario usuario = (Usuario) user;

        List<Perfil> perfisUsuario = perfilBO.getDAO().getInitialized(usuario.getPerfisDefinitivo());

        if (perfisUsuario.contains(perfil)) {
            if (usuario.getAutenticacaoLdap() == false) {

                if (!usuario.isSuperUsuario()) {
                    return super.authenticateUserPassword(user, password);
                } else {
                    return super.authenticateUserPassword(user, password);
                }
            } else {

                try {
                    if (!usuario.isSuperUsuario()) {

                        LdapContext context = ActiveDirectory.getConnection(Utils.gerarDomain(user.getUserLogin()), password, "zldap.pi.gov.br");
                        context.close();
                        return user;

                    } else {
                        LdapContext context = ActiveDirectory.getConnection(Utils.gerarDomain(user.getUserLogin()), password, "zldap.pi.gov.br");
                        context.close();
                        return user;
                    }

                } catch (AuthenticationException ex) {
                    //erro de autenticacao retornar nulo, pois o usuario nao foi autenticado
                    return null;
                } catch (CommunicationException ex) {
                    logger.log(Level.SEVERE, "Erro na autenticacao Active Directory", ex);
                    addErrorMessage("Erro ao se comunicar com o Servidor Active Directory. Entre em contato com o Administrador");
                    return null;
                } catch (NamingException ex) {
                    logger.log(Level.SEVERE, "Erro na autenticacao Active Directory", ex);
                    addErrorMessage("Erro ao se comunicar com o Servidor Active Directory. Entre em contato com o Administrador");
                    return null;
                }

            }
        } else {
            addErrorMessage("Perfil de Acesso selecionado não é permitido para esse usuário!");

            return null;
        }

    }

    public List<Organizacao> getOrganizacoes() {
        return organizacoes;
    }

    public void setOrganizacoes(List<Organizacao> organizacoes) {
        this.organizacoes = organizacoes;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public List<Organizacao> getOpms() {
        return opms;
    }

    public void setOpms(List<Organizacao> opms) {
        this.opms = opms;
    }

    public List<Organizacao> getApoios() {
        return apoios;
    }

    public void setApoios(List<Organizacao> apoios) {
        this.apoios = apoios;
    }

    public boolean isMostrarOpm() {
        return mostrarOpm;
    }

    public void setMostrarOpm(boolean mostrarOpm) {
        this.mostrarOpm = mostrarOpm;
    }

    public boolean isMostrarApoio() {
        return mostrarApoio;
    }

    public void setMostrarApoio(boolean mostrarApoio) {
        this.mostrarApoio = mostrarApoio;
    }

    public List<Perfil> getPerfis() {
        List<Perfil> perfis;
        perfil = new Perfil();
        Restrictions restrictions = new Restrictions();
        restrictions.add("mostrar", true);
        restrictions.add("ativo", true);

        perfis = perfilBO.getDAO().list(restrictions, "descricao");

        return perfis;
    }

    public void chancePerfil() {

        if (perfil != null) {
            organizacoes = new ArrayList<Organizacao>();
            if (perfil.getDescricao() != null) {
                if (perfil.getDescricao().equals("ADMINISTRADOR")) {
                    mostrarOpm = false;
                    mostrarApoio = false;
                }
                if (perfil.getDescricao().equals("ATENDENTE")) {
                    mostrarOpm = false;
                    mostrarApoio = false;
                }
                if (perfil.getDescricao().equals("RÁDIO OPERADOR") || perfil.getDescricao().equals("SUPERVISOR")) {
                    mostrarOpm = true;
                    mostrarApoio = false;
                }

                if (perfil.getDescricao().equals("APOIO")) {
                    mostrarOpm = false;
                    mostrarApoio = true;
                }
            } else {
                organizacoes = null;
                mostrarOpm = false;
                mostrarApoio = false;
            }
        } else {
            organizacoes = null;
            mostrarOpm = false;
            mostrarApoio = false;
        }

    }

}
