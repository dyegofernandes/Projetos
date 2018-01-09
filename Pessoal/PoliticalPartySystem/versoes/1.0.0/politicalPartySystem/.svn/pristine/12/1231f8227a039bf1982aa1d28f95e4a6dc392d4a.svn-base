package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.CityDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.City;

/**
 *
 * @author Juniel
 */
@Stateless
public class CityBO extends AbstractBusinessObject<City> {

    @EJB
    private CityDAO cityDAO;
    
    @Override
    public CityDAO getDAO() {
        return cityDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(City city) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
