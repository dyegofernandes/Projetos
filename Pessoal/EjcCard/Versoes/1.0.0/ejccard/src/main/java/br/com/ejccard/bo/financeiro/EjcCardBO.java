package br.com.ejccard.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.ejccard.dao.financeiro.EjcCardDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.ejccard.modelo.financeiro.EjcCard;

/**
 *
 * @author Juniel
 */
@Stateless
public class EjcCardBO extends AbstractBusinessObject<EjcCard> {

    @EJB
    private EjcCardDAO ejcCardDAO;
    
    @Override
    public EjcCardDAO getDAO() {
        return ejcCardDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(EjcCard ejcCard) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
