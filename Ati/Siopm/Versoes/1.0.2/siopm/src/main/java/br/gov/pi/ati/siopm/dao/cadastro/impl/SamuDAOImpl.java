package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.SamuDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Samu;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SamuDAOImpl extends BaseDAOImpl<Samu> implements SamuDAO {

    @Override
    public Class getEntityClass() {
        return Samu.class;
    }

}
