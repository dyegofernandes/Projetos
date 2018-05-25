package br.gov.pi.ati.sisrh.bo.cadastro;

import br.gov.pi.ati.sisrh.dao.cadastro.FichaDeVisitaDomiciliarDAO;
import br.gov.pi.ati.sisrh.modelo.cadastro.FichaDeVisitaDomiciliar;
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
