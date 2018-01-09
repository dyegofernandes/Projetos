package br.com.politicalpartysystem.dao.cadastro.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.cadastro.UserPoliticalPartyDAO;
import br.com.politicalpartysystem.modelo.cadastro.UserPoliticalParty;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UserPoliticalPartyDAOImpl extends BaseDAOImpl<UserPoliticalParty> implements UserPoliticalPartyDAO {

    @Override
    public Class getEntityClass() {
        return UserPoliticalParty.class;
    }

}
