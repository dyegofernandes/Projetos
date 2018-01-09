package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.StateDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.State;

/**
 *
 * @author Juniel
 */
@Stateless
public class StateBO extends AbstractBusinessObject<State> {

    @EJB
    private StateDAO stateDAO;
    
    @Override
    public StateDAO getDAO() {
        return stateDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(State state) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
