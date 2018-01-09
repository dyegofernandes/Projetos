package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.ArmaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Arma;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArmaDAOImpl extends BaseDAOImpl<Arma> implements ArmaDAO {

    @Override
    public Class getEntityClass() {
        return Arma.class;
    }

}
