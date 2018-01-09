package com.ebol.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.cadastro.BancoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.cadastro.Banco;

/**
 *
 * @author Juniel
 */
@Stateless
public class BancoBO extends AbstractBusinessObject<Banco> {

    @EJB
    private BancoDAO bancoDAO;
    
    @Override
    public BancoDAO getDAO() {
        return bancoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Banco banco) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
