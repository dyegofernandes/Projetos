package br.com.weblicita.mb.controleacesso;

import br.com.weblicita.bo.cadastro.TelefoneBO;
import br.com.weblicita.bo.controleacesso.SolicitacaoRecuperacaoSenhaBO;
import br.com.weblicita.bo.controleacesso.UsuarioBO;
import br.com.weblicita.bo.controleacesso.UsuarioMenuBO;
import br.com.weblicita.dao.controleacesso.AcessoSistemaDAO;
import br.com.weblicita.modelo.cadastro.Telefone;
import br.com.weblicita.modelo.controleacesso.AcessoSistema;
import br.com.weblicita.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.weblicita.modelo.controleacesso.Usuario;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.primefaces.LazyDataModelImpl;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.i18n.I18N;
import com.xpert.persistence.query.Restriction;
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

    @EJB
    private TelefoneBO telefoneBO;

    private String telefone = "";

    private LazyDataModelImpl<AcessoSistema> ultimosAcessos;

    @Override
    public void init() {
        if (getEntity().getId() != null) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addTelefone() {
        if (telefone.equals("")) {
            FacesMessageUtils.error("O número do telefone é obrigatório!");
        } else {
            Telefone telefoneTemp = new Telefone();
            telefoneTemp.setNumero(telefone);
            getEntity().getTelefones().add(telefoneTemp);

            telefone = "";
        }
    }

    public void removerTelefone(Telefone telefone) {
        getEntity().getTelefones().remove(telefone);
    }
}
