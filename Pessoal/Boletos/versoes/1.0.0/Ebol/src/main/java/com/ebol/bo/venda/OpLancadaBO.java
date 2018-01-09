package com.ebol.bo.venda;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.venda.OpLancadaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.venda.OpLancada;

/**
 *
 * @author Juniel
 */
@Stateless
public class OpLancadaBO extends AbstractBusinessObject<OpLancada> {

    @EJB
    private OpLancadaDAO opLancadaDAO;
    
    @Override
    public OpLancadaDAO getDAO() {
        return opLancadaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(OpLancada opLancada) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
