package br.com.politicalpartysystem.dao.cadastro.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.cadastro.IndividualPersonDAO;
import br.com.politicalpartysystem.modelo.cadastro.IndividualPerson;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class IndividualPersonDAOImpl extends BaseDAOImpl<IndividualPerson> implements IndividualPersonDAO {

    @Override
    public Class getEntityClass() {
        return IndividualPerson.class;
    }

}
