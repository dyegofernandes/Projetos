package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.ElementoDeDespesaBO;
import br.gov.pi.ati.modelo.cadastro.ElementoDeDespesa;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ElementoDeDespesaMB extends AbstractBaseBean<ElementoDeDespesa> implements Serializable {

    @EJB
    private ElementoDeDespesaBO elementoDeDespesaBO;

    @Override
    public ElementoDeDespesaBO getBO() {
        return elementoDeDespesaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
