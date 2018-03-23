package br.gov.pi.ati.sccd.mb.controleacesso;

import br.gov.pi.ati.sccd.bo.controleacesso.AcessoSistemaBO;
import br.gov.pi.ati.sccd.dao.controleacesso.UsuarioDAO;
import br.gov.pi.ati.sccd.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.sccd.modelo.controleacesso.Usuario;
import br.gov.pi.ati.sccd.util.Utils;
import com.xpert.i18n.I18N;
import com.xpert.security.ActiveDirectory;
import com.xpert.security.bean.SecurityLoginBean;
import com.xpert.security.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
public class LoginMB extends SecurityLoginBean {

    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private AcessoSistemaBO acessoSistemaBO;
    @ManagedProperty(value = "#{sessaoUsuarioMB}")
    private SessaoUsuarioMB sessaoUsuarioMB;
    private static final Logger logger = Logger.getLogger(LoginMB.class.getName());

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
        acessoSistemaBO.save(usuario);
    }

    @Override
    public Class getUserClass() {
        return Usuario.class;
    }

    @Override
    public SessaoUsuarioMB getUserSession() {
        return getSessaoUsuarioMB();
    }
    
    @Override
    public User authenticateUserPassword(User user, String password) {
        //se nao for LDAP
        if (((Usuario) user).getAutenticacaoLdap() == false) {
            return super.authenticateUserPassword(user, password);
        } else {
            try {
                LdapContext context = ActiveDirectory.getConnection(Utils.gerarDomain(user.getUserLogin()), password, "zldap.pi.gov.br");
                context.close();
                return user;
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
    }

    public SessaoUsuarioMB getSessaoUsuarioMB() {
        return sessaoUsuarioMB;
    }

    public void setSessaoUsuarioMB(SessaoUsuarioMB sessaoUsuarioMB) {
        this.sessaoUsuarioMB = sessaoUsuarioMB;
    }
}
