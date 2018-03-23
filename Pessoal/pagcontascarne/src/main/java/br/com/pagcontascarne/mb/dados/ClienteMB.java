package br.com.pagcontascarne.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.pagcontascarne.bo.dados.ClienteBO;
import br.com.pagcontascarne.modelo.controleacesso.Usuario;
import br.com.pagcontascarne.modelo.dados.Cliente;
import br.com.pagcontascarne.modelo.vos.FiltrosBusca;
import br.com.pagcontascarne.util.SessaoUtils;
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
    
    private List<Cliente> clientes;
    
    Usuario usuarioAtual = SessaoUtils.getUser();
    
    private FiltrosBusca filtros;
    
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
        filtros = new FiltrosBusca();
        filtros.setConvenio(usuarioAtual.getConvenio());
        if (getEntity().getId() == null) {
            getEntity().setConvenio(getDAO().getInitialized(usuarioAtual.getConvenio()));
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
}
