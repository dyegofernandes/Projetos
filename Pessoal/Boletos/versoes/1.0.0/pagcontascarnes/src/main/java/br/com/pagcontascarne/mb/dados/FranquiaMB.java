package br.com.pagcontascarne.mb.dados;

import br.com.pagcontascarne.bo.dados.CidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.FranquiaBO;
import br.com.pagcontascarne.modelo.dados.Cidade;
import br.com.pagcontascarne.modelo.dados.Franquia;
import br.com.pagcontascarne.modelo.dados.Uf;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FranquiaMB extends AbstractBaseBean<Franquia> implements Serializable {

    @EJB
    private FranquiaBO franquiaBO;

    @EJB
    private CidadeBO cidadeBO;

    private Uf ufFilter;
    
    private FiltrosBusca filtros;
    
    private List<Franquia> franquias;

    @Override
    public FranquiaBO getBO() {
        return franquiaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        if (getEntity().getCidade() != null) {
            Cidade cidadeTemp = getDAO().getInitialized(getEntity().getCidade());
            ufFilter = getDAO().getInitialized(cidadeTemp.getUf());
        }
    }

    public Uf getUfFilter() {
        return ufFilter;
    }

    public void setUfFilter(Uf ufFilter) {
        this.ufFilter = ufFilter;
    }

    public void chanceTipoPessoa() {
        getEntity().setCpf_cnpj(null);
        getEntity().setInsc_est(null);
        getEntity().setNome_fantasia(null);
        getEntity().setRazao_social(null);
    }

    public List<Cidade> autocompleteCidade(String nome) {
        return cidadeBO.listarCidadePeloNomeEEstado(ufFilter, nome);
    }

    public List<Cidade> autocompleteCidadeFiltro(String nome) {
        return cidadeBO.listarCidadePeloNomeEEstado(filtros.getEstado(), nome);
    }

    public FiltrosBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosBusca filtros) {
        this.filtros = filtros;
    }

    public List<Franquia> getFranquias() {
        return franquias;
    }

    public void setFranquias(List<Franquia> franquias) {
        this.franquias = franquias;
    }

    public void buscar(){
        franquias = getBO().franquias(filtros);
    }
}
