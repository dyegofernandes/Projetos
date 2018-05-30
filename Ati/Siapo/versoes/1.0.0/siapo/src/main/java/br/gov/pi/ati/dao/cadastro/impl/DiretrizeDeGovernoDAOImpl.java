package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.DiretrizeDeGovernoDAO;
import br.gov.pi.ati.modelo.cadastro.DiretrizeDeGoverno;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DiretrizeDeGovernoDAOImpl extends BaseDAOImpl<DiretrizeDeGoverno> implements DiretrizeDeGovernoDAO {

    @Override
    public Class getEntityClass() {
        return DiretrizeDeGoverno.class;
    }

}
