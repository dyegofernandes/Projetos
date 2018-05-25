package br.gov.pi.ati.sisrh.bo.cadastro;

import br.gov.pi.ati.sisrh.dao.cadastro.FichaDeVisitaInstitucionalLGBTDAO;
import br.gov.pi.ati.sisrh.modelo.cadastro.FichaDeVisitaInstitucionalLGBT;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FichaDeVisitaInstitucionalLGBTBO extends AbstractBusinessObject<FichaDeVisitaInstitucionalLGBT> {

    @EJB
    private FichaDeVisitaInstitucionalLGBTDAO fichaDeVisitaInstitucionalLGBTDAO;
    
    @Override
    public FichaDeVisitaInstitucionalLGBTDAO getDAO() {
        return fichaDeVisitaInstitucionalLGBTDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FichaDeVisitaInstitucionalLGBT fichaDeVisitaInstitucionalLGBT) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
