package br.com.weblicita.mb.controleacesso;

import br.com.weblicita.bo.controleacesso.SolicitacaoRecuperacaoSenhaBO;
import br.com.weblicita.bo.controleacesso.UsuarioBO;
import br.com.weblicita.bo.controleacesso.UsuarioMenuBO;
import br.com.weblicita.dao.controleacesso.AcessoSistemaDAO;
import br.com.weblicita.modelo.cadastro.Telefone;
import br.com.weblicita.modelo.controleacesso.AcessoSistema;
import br.com.weblicita.modelo.controleacesso.SituacaoUsuario;
import br.com.weblicita.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.weblicita.modelo.controleacesso.Usuario;
import br.com.weblicita.util.Utils;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.primefaces.LazyDataModelImpl;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.i18n.I18N;
import com.xpert.persistence.query.Restriction;
import com.xpert.persistence.query.Restrictions;
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

    private String telefone = "";

    private LazyDataModelImpl<AcessoSistema> ultimosAcessos;

    private boolean renderizarCampo;

    private boolean somenteLeitura;

    private boolean renderizarFormulario;

    private String cpf = "";

    private Telefone telefoneAdd;

    private List<Telefone> telefones = new ArrayList<Telefone>();

    @Override
    public void init() {
        telefoneAdd = new Telefone();
        telefones = new ArrayList<Telefone>();
        renderizarCampo = false;
        somenteLeitura = false;
        renderizarFormulario = false;
    }

    @Override
    public void postSave() {
        renderizarCampo = false;
        somenteLeitura = false;
        renderizarFormulario = false;
        setEntity(new Usuario());
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
            getEntity().setTelefones(telefones);
            usuarioBO.save(getEntity());

            //apos o cadastro feito tentar enviar senha do usuario
            if (novo) {
                getEntity().setCodigo(usuarioBO.gerarCodigo());
                try {
                    usuarioBO.enviarSenhaCadastro(getEntity());
                    FacesMessageUtils.info("solicitacaoRecuperacaoSenha.emailCadastroEnviado", getEntity().getEmail());
                } catch (BusinessException ex) {
                    FacesMessageUtils.warning("solicitacaoRecuperacaoSenha.cadastroComSucessoSenhaNaoEnviada",
                            getEntity().getEmail(),
                            I18N.get(ex.getMessage(), ex.getParametros()));
                }
            }
            renderizarCampo = false;
            somenteLeitura = false;
            renderizarFormulario = false;
            setEntity(new Usuario());
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
        if (Utils.isNullOrEmpty(telefoneAdd.getNumero())) {
            FacesMessageUtils.error("O número do telefone é obrigatório!");
        } else {
            if (telefoneAdd.getTipo() != null) {
                telefones.add(telefoneAdd);
                telefoneAdd = new Telefone();
            } else {
                FacesMessageUtils.error("Tipo do telefone é obrigatório!");
            }

        }
    }

    public void removerTelefone(Telefone telefone) {
        telefones.remove(telefone);
    }

    public boolean isRenderizarCampo() {
        return renderizarCampo;
    }

    public void setRenderizarCampo(boolean renderizarCampo) {
        this.renderizarCampo = renderizarCampo;
    }

    public boolean isSomenteLeitura() {
        return somenteLeitura;
    }

    public void setSomenteLeitura(boolean somenteLeitura) {
        this.somenteLeitura = somenteLeitura;
    }

    public boolean isRenderizarFormulario() {
        return renderizarFormulario;
    }

    public void setRenderizarFormulario(boolean renderizarFormulario) {
        this.renderizarFormulario = renderizarFormulario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean habilitarBotaoDesativar() {
        return getEntity().getId() != null && getEntity().getSituacaoUsuario() == SituacaoUsuario.ATIVO;
    }

    public boolean habilitarBotaoAtivar() {
        return getEntity().getId() != null && getEntity().getSituacaoUsuario() == SituacaoUsuario.INATIVO;
    }

    public void novo() {
        setEntity(new Usuario());
        getEntity().setCodigo(usuarioBO.gerarCodigo());
        renderizarCampo = true;
        somenteLeitura = false;
        renderizarFormulario = true;
    }

    public void desativar() {
        if (getEntity().getId() != null) {
            getEntity().setSituacaoUsuario(SituacaoUsuario.INATIVO);
            renderizarCampo = false;
            somenteLeitura = false;
            renderizarFormulario = false;
            super.save();
        } else {
            FacesMessageUtils.error("Informe o Usuário a ser desativado!");
        }
    }

    public void ativar() {
        if (getEntity().getId() != null) {
            getEntity().setSituacaoUsuario(SituacaoUsuario.ATIVO);
            renderizarCampo = false;
            somenteLeitura = false;
            renderizarFormulario = false;
            super.save();
        } else {
            FacesMessageUtils.error("Informe o Usuário a ser Ativado!");
        }
    }

    public void editar() {
        if (getEntity().getId() != null) {
            renderizarCampo = true;
            somenteLeitura = false;
            renderizarFormulario = true;
        } else {
            FacesMessageUtils.error("Informe o Usuário a ser editado!");
        }
    }

    public void buscar() {
        setEntity(new Usuario());
        if (!Utils.isNullOrEmpty(cpf)) {
            Restrictions restrictions = new Restrictions();
            restrictions.add("cpf", cpf);
            Usuario usuarioTemp = getDAO().unique(restrictions);
            if (usuarioTemp != null) {
                renderizarCampo = false;
                somenteLeitura = true;
                renderizarFormulario = true;
                setEntity(usuarioTemp);
            } else {
                renderizarCampo = false;
                somenteLeitura = true;
                renderizarFormulario = false;
                FacesMessageUtils.error("Usuário não encontrado!");
            }
        } else {
            renderizarCampo = false;
            somenteLeitura = true;
            renderizarFormulario = false;
            FacesMessageUtils.error("Informe o cpf para busca!");
        }
    }

}
