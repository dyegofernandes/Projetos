package br.com.pagcontascarne.mb.controleacesso;

import br.com.pagcontascarne.bo.controleacesso.SolicitacaoRecuperacaoSenhaBO;
import br.com.pagcontascarne.bo.controleacesso.UsuarioBO;
import br.com.pagcontascarne.bo.controleacesso.UsuarioMenuBO;
import br.com.pagcontascarne.bo.dados.ConvenioBO;
import br.com.pagcontascarne.dao.controleacesso.AcessoSistemaDAO;
import br.com.pagcontascarne.modelo.controleacesso.AcessoSistema;
import br.com.pagcontascarne.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.SessaoUtils;
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

    @EJB
    private ConvenioBO convenioBO;

    private MenuModel menuModel;
    @EJB
    private UsuarioBO usuarioBO;
    @EJB
    private AcessoSistemaDAO acessoSistemaDAO;
    @EJB
    private SolicitacaoRecuperacaoSenhaBO solicitacaoRecuperacaoSenhaBO;

    private LazyDataModelImpl<AcessoSistema> ultimosAcessos;

    Usuario usuarioAtual = SessaoUtils.getUser();

    private FiltrosBusca filtros;

    private List<Usuario> usuarios;

    private List<Convenio> convenios;

    private List<Convenio> conveniosFiltro;

    @Override
    public void init() {
        filtros = new FiltrosBusca();
        filtros.setConvenio(usuarioAtual.getConvenio());
        filtros.setFranquia(usuarioAtual.getFranquia());
        convenios = new ArrayList<Convenio>();
        conveniosFiltro = new ArrayList<Convenio>();

        if (getEntity().getFranquia() != null) {
            convenios = convenioBO.convenioPelaFranquia(getEntity().getFranquia());
        } else {
            getEntity().setFranquia(getDAO().getInitialized(usuarioAtual.getFranquia()));
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
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
        try {
            //salvar usuario
            usuarioBO.save(getEntity());
            //apos o cadastro feito tentar enviar senha do usuario
            if (novo) {
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

    public FiltrosBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosBusca filtros) {
        this.filtros = filtros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void buscar() {
        usuarios = usuarioBO.usuarios(filtros);
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public List<Convenio> getConveniosFiltro() {
        return conveniosFiltro;
    }

    public void setConveniosFiltro(List<Convenio> conveniosFiltro) {
        this.conveniosFiltro = conveniosFiltro;
    }

    public void pegarConvenios() {
        convenios = new ArrayList<Convenio>();

        if (getEntity().getFranquia() != null) {
            convenios = convenioBO.convenioPelaFranquia(getEntity().getFranquia());
        }
    }

    public void pegarConveniosFiltros() {
        conveniosFiltro = new ArrayList<Convenio>();

        if (filtros.getFranquia() != null) {
            conveniosFiltro = convenioBO.convenioPelaFranquia(filtros.getFranquia());
        }
    }
}
