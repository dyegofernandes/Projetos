package br.gov.pi.siste.mb.controleacesso;

import br.gov.pi.siste.bo.controleacesso.SolicitacaoRecuperacaoSenhaBO;
import br.gov.pi.siste.bo.controleacesso.UsuarioBO;
import br.gov.pi.siste.bo.controleacesso.UsuarioMenuBO;
import br.gov.pi.siste.dao.controleacesso.AcessoSistemaDAO;
import br.gov.pi.siste.modelo.controleacesso.AcessoSistema;
import br.gov.pi.siste.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.siste.modelo.controleacesso.Usuario;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.primefaces.LazyDataModelImpl;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.i18n.I18N;
import com.xpert.persistence.query.JoinBuilder;
import com.xpert.persistence.query.Restriction;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.menu.MenuModel;
import br.gov.pi.siste.bo.cadastro.UnidadeBO;
import br.gov.pi.siste.modelo.cadastro.Unidade;

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

    @EJB
    private UnidadeBO unidadeBO;

    private LazyDataModelImpl<AcessoSistema> ultimosAcessos;

    private List<Unidade> unidades = new ArrayList<Unidade>();

    @Override
    public void init() {
        if (getEntity().getOrgao() != null) {
            unidades = unidadeBO.unidadesPorOrgao(getEntity().getOrgao());
        } else {
            getEntity().setUnidade(new Unidade());
            unidades = new ArrayList<Unidade>();
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

    public void carregarUnidadesPorOrgao() {
        if (getEntity().getOrgao() != null) {
            unidades = unidadeBO.unidadesPorOrgao(getEntity().getOrgao());
        } else {
            getEntity().setUnidade(new Unidade());
            unidades = new ArrayList<Unidade>();
        }
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
        try {
            //salvar usuario
            usuarioBO.save(getEntity());
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
        return "usuario.orgao, usuario.unidade, usuario.nome";
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("usuario")
                .leftJoinFetch("usuario.orgao", "orgao").leftJoinFetch("usuario.unidade", "unidade")
                .leftJoinFetch("unidade.endereco", "endereco").leftJoinFetch("endereco.cidade", "cidade");
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

    public List<Unidade> getUnidades() {
        return unidades;
    }

}
