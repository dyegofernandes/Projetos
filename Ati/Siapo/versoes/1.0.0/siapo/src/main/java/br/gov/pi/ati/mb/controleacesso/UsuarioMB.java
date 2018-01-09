package br.gov.pi.ati.mb.controleacesso;

import br.gov.pi.ati.bo.controleacesso.SolicitacaoRecuperacaoSenhaBO;
import br.gov.pi.ati.bo.controleacesso.UsuarioBO;
import br.gov.pi.ati.bo.controleacesso.UsuarioMenuBO;
import br.gov.pi.ati.dao.controleacesso.AcessoSistemaDAO;
import br.gov.pi.ati.modelo.cadastro.UnidadeGestora;
import br.gov.pi.ati.modelo.controleacesso.AcessoSistema;
import br.gov.pi.ati.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.primefaces.LazyDataModelImpl;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.i18n.I18N;
import com.xpert.persistence.query.Restriction;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Ayslan
 */
@ManagedBean
@ViewScoped
public class UsuarioMB extends AbstractBaseBean<Usuario> implements Serializable {

    @EJB
    private UsuarioMenuBO usuarioMenuBO;
    private MenuModel menuModel;
    @EJB
    private UsuarioBO usuarioBO;
    @EJB
    private AcessoSistemaDAO acessoSistemaDAO;
    @EJB
    private SolicitacaoRecuperacaoSenhaBO solicitacaoRecuperacaoSenhaBO;

    private LazyDataModelImpl<AcessoSistema> ultimosAcessos;

    private List<UnidadeGestora> unidadesAcesso;

    private UnidadeGestora unidadeGestora;

    @Override
    public void init() {
        unidadeGestora = new UnidadeGestora();
        unidadesAcesso = new ArrayList<UnidadeGestora>();

        if (getEntity().getId() != null) {
            unidadesAcesso = (List<UnidadeGestora>) getBO().getDAO().getInitialized(getEntity().getUnidadesDeAcesso());
        }
    }

    public void enviarEmailRecuperacaoSenha() {
        try {
            solicitacaoRecuperacaoSenhaBO.save(getEntity().getEmail(), TipoRecuperacaoSenha.ESQUECI_SENHA);
            FacesMessageUtils.info("solicitacaoRecuperacaoSenha.instrucoesEnviadas");
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    public void detail() {
        carregarMenuUsuario();
        carregarUltimosAcessos();
    }

    /**
     * cria um lazy data model com os ultimos acessos do usuario
     */
    public void carregarUltimosAcessos() {
        //aqui e adicionado o usuario selecionado
        ultimosAcessos = new LazyDataModelImpl<AcessoSistema>("dataHora DESC", Restriction.equals("usuario", getEntity()), acessoSistemaDAO);
    }

    /**
     * carrega o menu baseado nos perfis do usuario
     */
    public void carregarMenuUsuario() {
        if (getEntity().getId() != null) {
            menuModel = usuarioMenuBO.criarMenu(getEntity());
        }
    }

    @Override
    public void save() {
        boolean novo = getEntity().getId() == null;
        getEntity().setUnidadesDeAcesso(unidadesAcesso);
        try {
            getBO().save(getEntity());
            //apos o cadastro feito tentar enviar senha do usuario
            if (novo && getEntity().getAutenticacaoLdap() == false) {
                try {
                    usuarioBO.enviarSenhaCadastro(getEntity());
                    FacesMessageUtils.info("solicitacaoRecuperacaoSenha.emailCadastroEnviado", getEntity().getEmail());
                } catch (BusinessException ex) {
                    FacesMessageUtils.warning("solicitacaoRecuperacaoSenha.cadastroComSucessoSenhaNaoEnviada",
                            getEntity().getEmail(),
                            I18N.get(ex.getMessage(), ex.getParametros()));
                }
            }
            FacesMessageUtils.sucess();
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    @Override
    public AbstractBusinessObject getBO() {
        return usuarioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }

    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

    public LazyDataModelImpl<AcessoSistema> getUltimosAcessos() {
        return ultimosAcessos;
    }

    public void setUltimosAcessos(LazyDataModelImpl<AcessoSistema> ultimosAcessos) {
        this.ultimosAcessos = ultimosAcessos;
    }

    public List<UnidadeGestora> getUnidadesAcesso() {
        return unidadesAcesso;
    }

    public void setUnidadesAcesso(List<UnidadeGestora> unidadesAcesso) {
        this.unidadesAcesso = unidadesAcesso;
    }

    public void addUnidadeAcesso() {
        if (unidadeGestora != null) {
            if (unidadeGestoraJahAdd(unidadeGestora)) {
                FacesMessageUtils.error("Unidade Gestora já adicionada!");
            } else {
                unidadesAcesso.add(unidadeGestora);
                unidadeGestora = new UnidadeGestora();

            }
        } else {
            FacesMessageUtils.error("Unidade Gestora é obrigatória!");
        }
    }

    public void removerUnidadeAcesso(UnidadeGestora unidade) {
        unidadesAcesso.remove(unidade);
    }

    private boolean unidadeGestoraJahAdd(UnidadeGestora unidade) {
        for (UnidadeGestora unid : unidadesAcesso) {
            if (unid.equals(unidade)) {
                return true;
            }
        }
        return false;
    }
}
