package br.com.pagcontascarne.mb.dados;

import br.com.pagcontascarne.bo.dados.ConvenioBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.ProdutoBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Convenio;
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
    
    @EJB
    private ConvenioBO convenioBO;

    private Usuario usuarioAtual = SessaoUtils.getUser();

    private List<Produto> produtos;

    private FiltrosBusca filtros;
    
    private List<Convenio> conveniosFiltros;
    
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
        filtros.setFranquia(getDAO().getInitialized(usuarioAtual.getFranquia()));
        filtros.setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        conveniosFiltros = new ArrayList<Convenio>();
        pegarConveniosFiltros();
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

    public List<Convenio> getConveniosFiltros() {
        return conveniosFiltros;
    }

    public void setConveniosFiltros(List<Convenio> conveniosFiltros) {
        this.conveniosFiltros = conveniosFiltros;
    }

    public void buscar() {
        produtos = getBO().listar(filtros);
    }
    
    public void pegarConveniosFiltros() {
        conveniosFiltros = new ArrayList<Convenio>();

        if (filtros.getFranquia() != null) {
            conveniosFiltros = convenioBO.convenioPelaFranquia(filtros.getFranquia());
        }
    }
}
