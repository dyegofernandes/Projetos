package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.PersonDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.Person;

/**
 *
 * @author Juniel
 */
@Stateless
public class PersonBO extends AbstractBusinessObject<Person> {

    @EJB
    private PersonDAO personDAO;
    
    @Override
    public PersonDAO getDAO() {
        return personDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Person person) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
