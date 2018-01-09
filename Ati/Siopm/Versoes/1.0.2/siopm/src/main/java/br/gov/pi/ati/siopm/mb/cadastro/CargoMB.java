package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.CargoBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Cargo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CargoMB extends AbstractBaseBean<Cargo> implements Serializable {

    @EJB
    private CargoBO cargoBO;

    @Override
    public CargoBO getBO() {
        return cargoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new Cargo());
    }
    
    
}
