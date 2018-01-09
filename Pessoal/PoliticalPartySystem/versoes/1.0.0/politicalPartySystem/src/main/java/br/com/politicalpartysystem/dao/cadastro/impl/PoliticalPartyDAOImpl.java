package br.com.politicalpartysystem.dao.cadastro.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.cadastro.PoliticalPartyDAO;
import br.com.politicalpartysystem.modelo.cadastro.PoliticalParty;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PoliticalPartyDAOImpl extends BaseDAOImpl<PoliticalParty> implements PoliticalPartyDAO {

    @Override
    public Class getEntityClass() {
        return PoliticalParty.class;
    }

}
