package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.PoliciaRodoviariaFederalBO;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaRodoviariaFederal;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PoliciaRodoviariaFederalMB extends AbstractBaseBean<PoliciaRodoviariaFederal> implements Serializable {

    @EJB
    private PoliciaRodoviariaFederalBO policiaRodoviariaFederalBO;

    @Override
    public PoliciaRodoviariaFederalBO getBO() {
        return policiaRodoviariaFederalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
