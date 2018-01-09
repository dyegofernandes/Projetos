package com.opfacil.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.opfacil.dao.cadastro.MotivoPagamentoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.opfacil.modelo.cadastro.MotivoPagamento;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class MotivoPagamentoBO extends AbstractBusinessObject<MotivoPagamento> {

    @EJB
    private MotivoPagamentoDAO motivoPagamentoDAO;
    
    @Override
    public MotivoPagamentoDAO getDAO() {
        return motivoPagamentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome");
    }

    @Override
    public void validate(MotivoPagamento motivoPagamento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
