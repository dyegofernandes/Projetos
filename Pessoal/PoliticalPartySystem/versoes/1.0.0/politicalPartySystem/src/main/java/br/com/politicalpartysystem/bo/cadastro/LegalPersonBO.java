package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.LegalPersonDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.LegalPerson;

/**
 *
 * @author Juniel
 */
@Stateless
public class LegalPersonBO extends AbstractBusinessObject<LegalPerson> {

    @EJB
    private LegalPersonDAO legalPersonDAO;
    
    @Override
    public LegalPersonDAO getDAO() {
        return legalPersonDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(LegalPerson legalPerson) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
