package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.PoliciaFederalBO;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaFederal;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PoliciaFederalMB extends AbstractBaseBean<PoliciaFederal> implements Serializable {

    @EJB
    private PoliciaFederalBO policiaFederalBO;

    @Override
    public PoliciaFederalBO getBO() {
        return policiaFederalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
