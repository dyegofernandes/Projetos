package br.com.politicalpartysystem.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.politicalpartysystem.dao.cadastro.MemberPoliticalPartyDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.politicalpartysystem.modelo.cadastro.MemberPoliticalParty;

/**
 *
 * @author Juniel
 */
@Stateless
public class MemberPoliticalPartyBO extends AbstractBusinessObject<MemberPoliticalParty> {

    @EJB
    private MemberPoliticalPartyDAO memberPoliticalPartyDAO;
    
    @Override
    public MemberPoliticalPartyDAO getDAO() {
        return memberPoliticalPartyDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MemberPoliticalParty memberPoliticalParty) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
