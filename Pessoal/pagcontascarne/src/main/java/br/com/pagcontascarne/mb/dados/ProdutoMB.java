package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.ProdutoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Produto;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.SessaoUtils;
import java.util.ArrayList;
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

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<Produto> produtos;

    private FiltrosBusca filtros;

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
        produtos = new ArrayList<Produto>();
        filtros = new FiltrosBusca();
        filtros.setConvenio(usuarioAtual.getConvenio());
        if (getEntity().getId() == null) {
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        }
    }

    public List<Produto> autocomplete(String nome) {
        return getBO().produtosPeloNomeEConvenio(nome, usuarioAtual.getConvenio());
    }

    public FiltrosBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosBusca filtros) {
        this.filtros = filtros;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void buscar() {
        produtos = getBO().listar(filtros);
    }
}
