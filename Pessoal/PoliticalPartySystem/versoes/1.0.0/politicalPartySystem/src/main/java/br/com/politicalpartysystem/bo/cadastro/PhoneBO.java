package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.PhoneDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.Phone;

/**
 *
 * @author Juniel
 */
@Stateless
public class PhoneBO extends AbstractBusinessObject<Phone> {

    @EJB
    private PhoneDAO phoneDAO;
    
    @Override
    public PhoneDAO getDAO() {
        return phoneDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Phone phone) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
