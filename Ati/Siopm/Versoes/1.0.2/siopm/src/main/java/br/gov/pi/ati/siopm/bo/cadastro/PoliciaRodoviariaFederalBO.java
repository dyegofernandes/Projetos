package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.PoliciaRodoviariaFederalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaRodoviariaFederal;

/**
 *
 * @author Juniel
 */
@Stateless
public class PoliciaRodoviariaFederalBO extends AbstractBusinessObject<PoliciaRodoviariaFederal> {

    @EJB
    private PoliciaRodoviariaFederalDAO policiaRodoviariaFederalDAO;
    
    @Override
    public PoliciaRodoviariaFederalDAO getDAO() {
        return policiaRodoviariaFederalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PoliciaRodoviariaFederal policiaRodoviariaFederal) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
