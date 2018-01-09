package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.FichaDeVisitaDomiciliarDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.FichaDeVisitaDomiciliar;

/**
 *
 * @author Juniel
 */
@Stateless
public class FichaDeVisitaDomiciliarBO extends AbstractBusinessObject<FichaDeVisitaDomiciliar> {

    @EJB
    private FichaDeVisitaDomiciliarDAO fichaDeVisitaDomiciliarDAO;
    
    @Override
    public FichaDeVisitaDomiciliarDAO getDAO() {
        return fichaDeVisitaDomiciliarDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(FichaDeVisitaDomiciliar fichaDeVisitaDomiciliar) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
