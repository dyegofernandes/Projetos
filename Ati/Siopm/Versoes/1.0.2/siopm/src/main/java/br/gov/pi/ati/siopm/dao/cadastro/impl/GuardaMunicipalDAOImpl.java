package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.GuardaMunicipalDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.GuardaMunicipal;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class GuardaMunicipalDAOImpl extends BaseDAOImpl<GuardaMunicipal> implements GuardaMunicipalDAO {

    @Override
    public Class getEntityClass() {
        return GuardaMunicipal.class;
    }

}
