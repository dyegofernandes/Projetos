package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.IndividualPersonDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.IndividualPerson;

/**
 *
 * @author Juniel
 */
@Stateless
public class IndividualPersonBO extends AbstractBusinessObject<IndividualPerson> {

    @EJB
    private IndividualPersonDAO individualPersonDAO;
    
    @Override
    public IndividualPersonDAO getDAO() {
        return individualPersonDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(IndividualPerson individualPerson) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
