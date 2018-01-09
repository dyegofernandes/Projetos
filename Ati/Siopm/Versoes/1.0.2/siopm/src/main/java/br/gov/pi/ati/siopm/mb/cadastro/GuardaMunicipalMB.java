package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.GuardaMunicipalBO;
import br.gov.pi.ati.siopm.modelo.cadastro.GuardaMunicipal;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class GuardaMunicipalMB extends AbstractBaseBean<GuardaMunicipal> implements Serializable {

    @EJB
    private GuardaMunicipalBO guardaMunicipalBO;

    @Override
    public GuardaMunicipalBO getBO() {
        return guardaMunicipalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
