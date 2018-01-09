package com.ebol.bo.venda;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.venda.DescontoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.venda.Desconto;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class DescontoBO extends AbstractBusinessObject<Desconto> {

    @EJB
    private DescontoDAO descontoDAO;
    
    @Override
    public DescontoDAO getDAO() {
        return descontoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("venda","descricao");
    }

    @Override
    public void validate(Desconto desconto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
