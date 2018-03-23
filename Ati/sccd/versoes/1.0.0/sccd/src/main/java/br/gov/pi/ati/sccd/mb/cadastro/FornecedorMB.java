package br.gov.pi.ati.sccd.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.cadastro.FornecedorBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Fornecedor;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FornecedorMB extends AbstractBaseBean<Fornecedor> implements Serializable {

    @EJB
    private FornecedorBO fornecedorBO;

    @Override
    public FornecedorBO getBO() {
        return fornecedorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    public List<Fornecedor> fornecedoresAtivos(){
        return getBO().fornecedoresAtivos();
    }
}
