package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.GrupoDeDespesaBO;
import br.gov.pi.ati.modelo.cadastro.GrupoDeDespesa;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class GrupoDeDespesaMB extends AbstractBaseBean<GrupoDeDespesa> implements Serializable {

    @EJB
    private GrupoDeDespesaBO grupoDeDespesaBO;

    @Override
    public GrupoDeDespesaBO getBO() {
        return grupoDeDespesaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
