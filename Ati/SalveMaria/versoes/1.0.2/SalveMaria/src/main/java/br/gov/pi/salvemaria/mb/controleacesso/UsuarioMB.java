package br.gov.pi.salvemaria.mb.controleacesso;

import br.gov.pi.salvemaria.bo.controleacesso.SolicitacaoRecuperacaoSenhaBO;
import br.gov.pi.salvemaria.bo.controleacesso.UsuarioBO;
import br.gov.pi.salvemaria.bo.controleacesso.UsuarioMenuBO;
import br.gov.pi.salvemaria.dao.controleacesso.AcessoSistemaDAO;
import br.gov.pi.salvemaria.modelo.controleacesso.AcessoSistema;
import br.gov.pi.salvemaria.modelo.controleacesso.TipoRecuperacaoSenha;
import br.gov.pi.salvemaria.modelo.controleacesso.Usuario;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.primefaces.LazyDataModelImpl;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.i18n.I18N;
import com.xpert.persistence.query.JoinBuilder;
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

    private LazyDataModelImpl<AcessoSistema> ultimosAcessos;

    @Override
    public void init() {
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
        if (getEntity().getUnidade() != null && getEntity().isSuperUsuario()) {
            FacesMessageUtils.error("Super Usuários não necessitam de Unidade!");
        } else {
            try {
                //salvar usuario
                usuarioBO.save(getEntity());
                //apos o cadastro feito tentar enviar senha do usuario
                if (novo) {
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

                }
                FacesMessageUtils.sucess();
            } catch (BusinessException ex) {
                FacesMessageUtils.error(ex);
            }
        }
    }

    @Override
    public AbstractBusinessObject getBO() {
        return usuarioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "unidade.nome, usuario.nome";
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

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("usuario").
                leftJoinFetch("usuario.unidade", "unidade")
                .leftJoinFetch("unidade.endereco", "endereco").leftJoinFetch("endereco.bairro", "bairro")
                .leftJoinFetch("bairro.cidade", "cidade");
    }

}
