package br.com.pagcontascarne.mb.dados;

import br.com.pagcontascarne.bo.dados.CidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.ClienteBO;
import br.com.pagcontascarne.bo.dados.ConvenioBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Cidade;
import br.com.pagcontascarne.modelo.dados.Cliente;
import br.com.pagcontascarne.modelo.dados.Convenio;
import br.com.pagcontascarne.modelo.dados.Uf;
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
public class ClienteMB extends AbstractBaseBean<Cliente> implements Serializable {

    @EJB
    private ClienteBO clienteBO;

    @EJB
    private CidadeBO cidadeBO;
    
    @EJB
    private ConvenioBO convenioBO;

    private Uf ufFilter;

    private List<Cliente> clientes;

    Usuario usuarioAtual = SessaoUtils.getUser();

    private FiltrosBusca filtros = new FiltrosBusca();

    private List<Convenio> conveniosFiltros;

    @Override
    public ClienteBO getBO() {
        return clienteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        filtros.setFranquia(getDAO().getInitialized(usuarioAtual.getFranquia()));
        filtros.setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        
        if (getEntity().getId() == null) {
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
        } else {
            Cidade cidadeTemp = getDAO().getInitialized(getEntity().getCidade());
            ufFilter = getDAO().getInitialized(cidadeTemp.getUf());
        }
    }

    public List<Cliente> autocomplete(String nome) {
        return getBO().clientesPeloNomeOrCnpjOuCpf(nome, usuarioAtual.getConvenio());
    }

    public void buscar() {
        clientes = getBO().listar(filtros);
    }

    public void chanceTipoPessoa() {
        getEntity().setCpf_cnpj(null);
        getEntity().setInsc_est_rg(null);
        getEntity().setNome_fantasia(null);
        getEntity().setCompleto_razao_social(null);
        filtros.setCpf_cnpj(null);
        filtros.setNome_fantasia(null);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public FiltrosBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltrosBusca filtros) {
        this.filtros = filtros;
    }

    public Uf getUfFilter() {
        return ufFilter;
    }

    public void setUfFilter(Uf ufFilter) {
        this.ufFilter = ufFilter;
    }

    public List<Cidade> autocompleteCidade(String nome) {
        return cidadeBO.listarCidadePeloNomeEEstado(ufFilter, nome);
    }

    public List<Cidade> autocompleteCidadeFiltro(String nome) {
        return cidadeBO.listarCidadePeloNomeEEstado(filtros.getEstado(), nome);
    }

    public List<Convenio> getConveniosFiltros() {
        return conveniosFiltros;
    }

    public void setConveniosFiltros(List<Convenio> conveniosFiltros) {
        this.conveniosFiltros = conveniosFiltros;
    }
    
    public void pegarConveniosFiltros() {
        conveniosFiltros = new ArrayList<Convenio>();

        if (filtros.getFranquia() != null) {
            conveniosFiltros = convenioBO.convenioPelaFranquia(filtros.getFranquia());
        }
    }
}
