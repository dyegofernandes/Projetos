package com.ebol.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.cadastro.Padrao_CobrancaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.cadastro.Padrao_Cobranca;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class Padrao_CobrancaBO extends AbstractBusinessObject<Padrao_Cobranca> {

    @EJB
    private Padrao_CobrancaDAO padrao_CobrancaDAO;
    
    @Override
    public Padrao_CobrancaDAO getDAO() {
        return padrao_CobrancaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Padrao_Cobranca padrao_Cobranca) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
