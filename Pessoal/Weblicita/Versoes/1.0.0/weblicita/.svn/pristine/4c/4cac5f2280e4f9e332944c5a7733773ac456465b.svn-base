package br.com.weblicita.bo.contrato;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.contrato.ContratoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.contrato.Contrato;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContratoBO extends AbstractBusinessObject<Contrato> {

    @EJB
    private ContratoDAO contratoDAO;
    
    @Override
    public ContratoDAO getDAO() {
        return contratoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Contrato contrato) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
