package com.ebol.mb.cadastro;

import com.ebol.bo.cadastro.CidadeBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.ClienteBO;
import com.ebol.bo.cadastro.ConvenioBO;
import com.ebol.modelo.cadastro.Cidade;
import com.ebol.modelo.cadastro.Cliente;
import com.ebol.modelo.cadastro.Convenio;
import com.ebol.modelo.controleacesso.Usuario;
import com.ebol.modelo.vos.FiltroBusca;
import com.ebol.util.SessaoUtils;
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

    private List<Cliente> clientes;
    
    private List<Cidade> cidades;
    
    private Convenio convenio;
    
    private Usuario usuario = new Usuario();
    
    private FiltroBusca filtros;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public FiltroBusca getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroBusca filtros) {
        this.filtros = filtros;
    }

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
        filtros = new FiltroBusca();
        usuario = SessaoUtils.getUser();
        filtros.setUsuario(usuario);
        convenio = clienteBO.getDAO().getInitialized(usuario.getConvenio());
        
        getEntity().setConvenio(convenio);
        
        cidades = cidadeBO.cidades();
    }
    
    public List<Cliente> clientesPorConvenio(){
        clientes = clienteBO.clientesPorConvenio(filtros);
        
        return clientes;
    }

}
