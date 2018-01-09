package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.NaturezaDeDespesaBO;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class NaturezaDeDespesaMB extends AbstractBaseBean<NaturezaDeDespesa> implements Serializable {

    @EJB
    private NaturezaDeDespesaBO naturezaDeDespesaBO;

    @Override
    public NaturezaDeDespesaBO getBO() {
        return naturezaDeDespesaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
