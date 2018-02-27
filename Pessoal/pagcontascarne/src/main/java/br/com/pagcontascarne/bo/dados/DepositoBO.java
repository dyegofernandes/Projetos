package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.DepositoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Deposito;

/**
 *
 * @author Juniel
 */
@Stateless
public class DepositoBO extends AbstractBusinessObject<Deposito> {

    @EJB
    private DepositoDAO depositoDAO;
    
    @Override
    public DepositoDAO getDAO() {
        return depositoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Deposito deposito) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
