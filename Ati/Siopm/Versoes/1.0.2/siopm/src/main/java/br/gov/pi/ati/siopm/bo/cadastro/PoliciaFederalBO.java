package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.PoliciaFederalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaFederal;

/**
 *
 * @author Juniel
 */
@Stateless
public class PoliciaFederalBO extends AbstractBusinessObject<PoliciaFederal> {

    @EJB
    private PoliciaFederalDAO policiaFederalDAO;
    
    @Override
    public PoliciaFederalDAO getDAO() {
        return policiaFederalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PoliciaFederal policiaFederal) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
