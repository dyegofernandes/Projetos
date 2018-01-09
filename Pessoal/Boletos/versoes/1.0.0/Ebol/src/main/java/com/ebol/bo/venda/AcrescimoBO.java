package com.ebol.bo.venda;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.venda.AcrescimoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.venda.Acrescimo;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class AcrescimoBO extends AbstractBusinessObject<Acrescimo> {

    @EJB
    private AcrescimoDAO acrescimoDAO;
    
    @Override
    public AcrescimoDAO getDAO() {
        return acrescimoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("venda","descricao");
    }

    @Override
    public void validate(Acrescimo acrescimo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
