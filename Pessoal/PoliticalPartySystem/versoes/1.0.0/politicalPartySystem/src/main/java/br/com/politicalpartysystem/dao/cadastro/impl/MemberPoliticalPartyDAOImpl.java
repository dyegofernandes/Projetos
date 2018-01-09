package br.com.politicalpartysystem.dao.cadastro.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.cadastro.MemberPoliticalPartyDAO;
import br.com.politicalpartysystem.modelo.cadastro.MemberPoliticalParty;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MemberPoliticalPartyDAOImpl extends BaseDAOImpl<MemberPoliticalParty> implements MemberPoliticalPartyDAO {

    @Override
    public Class getEntityClass() {
        return MemberPoliticalParty.class;
    }

}
