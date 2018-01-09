package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.CargoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Cargo;

/**
 *
 * @author Juniel
 */
@Stateless
public class CargoBO extends AbstractBusinessObject<Cargo> {

    @EJB
    private CargoDAO cargoDAO;
    
    @Override
    public CargoDAO getDAO() {
        return cargoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Cargo cargo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
