package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.GuardaMunicipalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.GuardaMunicipal;

/**
 *
 * @author Juniel
 */
@Stateless
public class GuardaMunicipalBO extends AbstractBusinessObject<GuardaMunicipal> {

    @EJB
    private GuardaMunicipalDAO guardaMunicipalDAO;
    
    @Override
    public GuardaMunicipalDAO getDAO() {
        return guardaMunicipalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(GuardaMunicipal guardaMunicipal) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
