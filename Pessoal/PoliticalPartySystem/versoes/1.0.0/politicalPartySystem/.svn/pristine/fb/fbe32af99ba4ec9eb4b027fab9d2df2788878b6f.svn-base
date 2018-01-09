package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.UserPoliticalPartyDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.UserPoliticalParty;

/**
 *
 * @author Juniel
 */
@Stateless
public class UserPoliticalPartyBO extends AbstractBusinessObject<UserPoliticalParty> {

    @EJB
    private UserPoliticalPartyDAO userPoliticalPartyDAO;
    
    @Override
    public UserPoliticalPartyDAO getDAO() {
        return userPoliticalPartyDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(UserPoliticalParty userPoliticalParty) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
