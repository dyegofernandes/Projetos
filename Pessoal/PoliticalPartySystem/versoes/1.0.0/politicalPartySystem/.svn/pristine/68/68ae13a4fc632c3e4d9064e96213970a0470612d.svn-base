package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.AddressDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.Address;

/**
 *
 * @author Juniel
 */
@Stateless
public class AddressBO extends AbstractBusinessObject<Address> {

    @EJB
    private AddressDAO addressDAO;
    
    @Override
    public AddressDAO getDAO() {
        return addressDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Address address) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
