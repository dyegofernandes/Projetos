package br.com.aprove.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.cadastro.ClienteBO;
import br.com.aprove.modelo.cadastro.Cliente;
import br.com.aprove.modelo.controleacesso.Usuario;
import br.com.aprove.util.SessaoUtils;
import br.com.aprove.vo.FiltroVO;
import com.xpert.faces.utils.FacesUtils;
import java.util.List;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class ClienteMB extends AbstractBaseBean<Cliente> implements Serializable {

    @EJB
    private ClienteBO clienteBO;

    private List<Cliente> clientes;

    private FiltroVO filtros;

    private Usuario usuarioAtual;

    public FiltroVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroVO filtros) {
        this.filtros = filtros;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public void init() {
        filtros = new FiltroVO();

        usuarioAtual = SessaoUtils.getUser();

        setarEmpresa(usuarioAtual);

        filtros.setUsuario(usuarioAtual);

        clientes = clienteBO.listarClientes(filtros);
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
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/cliente/listCliente.jsf");
        } else {
            setEntity(new Cliente());
        }

        setarEmpresa(usuarioAtual);
    }

    public void buscar() {
        clientes = clienteBO.listarClientes(filtros);
    }

    private void setarEmpresa(Usuario usuario) {
        if (!usuario.isSuperUsuario()) {
            if (usuario.getFilial() != null) {
                getEntity().setEmpresa(usuario.getFilial());
            } else {
                getEntity().setEmpresa(usuario.getMatriz());
            }

        }
    }
}
