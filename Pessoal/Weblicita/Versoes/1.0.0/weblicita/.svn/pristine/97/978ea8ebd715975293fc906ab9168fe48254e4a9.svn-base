package br.com.weblicita.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.AdministradorFornecedorBO;
import br.com.weblicita.modelo.cadastro.AdministradorFornecedor;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AdministradorFornecedorMB extends AbstractBaseBean<AdministradorFornecedor> implements Serializable {

    @EJB
    private AdministradorFornecedorBO administradorFornecedorBO;

    @Override
    public AdministradorFornecedorBO getBO() {
        return administradorFornecedorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
