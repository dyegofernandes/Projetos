package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.ProdutoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Produto;
import br.com.pagcontascarne.util.SessaoUtils;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ProdutoMB extends AbstractBaseBean<Produto> implements Serializable {

    @EJB
    private ProdutoBO produtoBO;

    Usuario usuarioAtual = SessaoUtils.getUser();

    @Override
    public ProdutoBO getBO() {
        return produtoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        if (getEntity().getId() == null) {
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        }
    }

    public List<Produto> autocomplete(String nome) {
        return getBO().produtosPeloNomeEConvenio(nome);
    }
}
