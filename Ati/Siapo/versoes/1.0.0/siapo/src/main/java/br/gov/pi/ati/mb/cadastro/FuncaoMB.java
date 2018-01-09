package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.FuncaoBO;
import br.gov.pi.ati.modelo.cadastro.Funcao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FuncaoMB extends AbstractBaseBean<Funcao> implements Serializable {

    @EJB
    private FuncaoBO funcaoBO;

    @Override
    public FuncaoBO getBO() {
        return funcaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
