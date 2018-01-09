package com.ebol.bo.venda;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.venda.DebitoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.venda.Debito;

/**
 *
 * @author Juniel
 */
@Stateless
public class DebitoBO extends AbstractBusinessObject<Debito> {

    @EJB
    private DebitoDAO debitoDAO;
    
    @Override
    public DebitoDAO getDAO() {
        return debitoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Debito debito) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
