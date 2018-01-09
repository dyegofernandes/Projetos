package com.opfacil.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.opfacil.dao.cadastro.UfDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.opfacil.modelo.cadastro.Uf;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class UfBO extends AbstractBusinessObject<Uf> {

    @EJB
    private UfDAO DAO;
    
    @Override
    public UfDAO getDAO() {
        return DAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome").add("sigla");
    }

    @Override
    public void validate(Uf object) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
