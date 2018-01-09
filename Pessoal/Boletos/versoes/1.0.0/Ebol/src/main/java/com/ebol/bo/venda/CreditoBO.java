package com.ebol.bo.venda;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.venda.CreditoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.venda.Credito;

/**
 *
 * @author Juniel
 */
@Stateless
public class CreditoBO extends AbstractBusinessObject<Credito> {

    @EJB
    private CreditoDAO creditoDAO;
    
    @Override
    public CreditoDAO getDAO() {
        return creditoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Credito credito) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
