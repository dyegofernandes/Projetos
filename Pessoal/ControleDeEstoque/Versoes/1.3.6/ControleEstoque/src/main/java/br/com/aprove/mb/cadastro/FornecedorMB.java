package br.com.aprove.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.cadastro.FornecedorBO;
import br.com.aprove.modelo.cadastro.Fornecedor;
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
public class FornecedorMB extends AbstractBaseBean<Fornecedor> implements Serializable {

    @EJB
    private FornecedorBO fornecedorBO;

    private Usuario usuarioAtual;

    private FiltroVO filtros;

    private List<Fornecedor> fornecedores;

    @Override
    public FornecedorBO getBO() {
        return fornecedorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        if (getId() != null) {
            FacesUtils.redirect("/view/cadastro/fornecedor/listFornecedor.jsf");
        } else {
            setEntity(new Fornecedor());
        }
    }

    @Override
    public void init() {
        filtros = new FiltroVO();

        usuarioAtual = SessaoUtils.getUser();

        setarEmpresa(usuarioAtual);

        filtros.setUsuario(usuarioAtual);

        fornecedores = fornecedorBO.listarFornecedores(filtros);
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

    public void buscar() {
        fornecedores = fornecedorBO.listarFornecedores(filtros);
    }

    public FiltroVO getFiltros() {
        return filtros;
    }

    public void setFiltros(FiltroVO filtros) {
        this.filtros = filtros;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }
    
    
}
