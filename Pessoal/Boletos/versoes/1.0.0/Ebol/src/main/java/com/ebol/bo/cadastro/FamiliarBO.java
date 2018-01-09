package com.ebol.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.cadastro.FamiliarDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.cadastro.Familiar;

/**
 *
 * @author Juniel
 */
@Stateless
public class FamiliarBO extends AbstractBusinessObject<Familiar> {

    @EJB
    private FamiliarDAO familiarDAO;
    
    @Override
    public FamiliarDAO getDAO() {
        return familiarDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Familiar familiar) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
