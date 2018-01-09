package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.CountryDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.Country;

/**
 *
 * @author Juniel
 */
@Stateless
public class CountryBO extends AbstractBusinessObject<Country> {

    @EJB
    private CountryDAO countryDAO;
    
    @Override
    public CountryDAO getDAO() {
        return countryDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Country country) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
