package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.FichaDeVisitaInstitucionalLGBTDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.FichaDeVisitaInstitucionalLGBT;

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
