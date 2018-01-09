package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.PoliticalPartyDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.PoliticalParty;

/**
 *
 * @author Juniel
 */
@Stateless
public class PoliticalPartyBO extends AbstractBusinessObject<PoliticalParty> {

    @EJB
    private PoliticalPartyDAO politicalPartyDAO;
    
    @Override
    public PoliticalPartyDAO getDAO() {
        return politicalPartyDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PoliticalParty politicalParty) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
