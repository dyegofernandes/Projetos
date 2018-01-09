package br.com.aprove.mb.controleacesso;

import br.com.aprove.bo.cadastro.Loja_FilialBO;
import br.com.aprove.bo.controleacesso.SolicitacaoRecuperacaoSenhaBO;
import br.com.aprove.bo.controleacesso.UsuarioBO;
import br.com.aprove.modelo.cadastro.Loja_Filial;
import br.com.aprove.modelo.controleacesso.TipoRecuperacaoSenha;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.vo.FiltroVO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.exception.BusinessException;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.faces.utils.FacesUtils;
import com.xpert.i18n.I18N;
import com.xpert.persistence.query.JoinBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ayslan
 */
@ManagedBean
@ViewScoped
public class UsuarioMB extends AbstractBaseBean<Usuario> implements Serializable {

    @EJB
    private UsuarioBO usuarioBO;
    @EJB
    private SolicitacaoRecuperacaoSenhaBO solicitacaoRecuperacaoSenhaBO;

    @EJB
    private Loja_FilialBO lojaBO;

    private List<Loja_Filial> lojasPorMatriz;

    private FiltroVO filtros = new FiltroVO();

    public void enviarEmailRecuperacaoSenha() {
        try {
            solicitacaoRecuperacaoSenhaBO.save(getEntity().getEmail(), TipoRecuperacaoSenha.ESQUECI_SENHA);
            FacesMessageUtils.info("solicitacaoRecuperacaoSenha.instrucoesEnviadas");
        } catch (BusinessException ex) {
            FacesMessageUtils.error(ex);
        }
    }

    @Override
    public void save() {
        boolean novo = getEntity().getId() == null;
        try {
            getBO().save(getEntity());
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

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("usuario")
                .leftJoinFetch("usuario.matriz", "matriz")
                .leftJoinFetch("usuario.filial", "filial");
    }

    @Override
    public void postSave() {
        if (getEntity().getId() != null) {
            FacesUtils.redirect("/view/controleAcesso/usuario/listUsuario.jsf");
        } else {
            setEntity(new Usuario());
        }
    }

    public void buscarLojaPorMatriz() {
        if (getEntity().getMatriz() != null) {
            filtros.setMatriz(getEntity().getMatriz());
            lojasPorMatriz = lojaBO.listarLoja_Filial(filtros);
        } else {
            getEntity().setFilial(null);
            lojasPorMatriz = null;
        }

    }

    public List<Loja_Filial> getLojasPorMatriz() {
        return lojasPorMatriz;
    }

    public void setLojasPorMatriz(List<Loja_Filial> lojasPorMatriz) {
        this.lojasPorMatriz = lojasPorMatriz;
    }

    public FiltroVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroVO filtros) {
        this.filtros = filtros;
    }
    
}
