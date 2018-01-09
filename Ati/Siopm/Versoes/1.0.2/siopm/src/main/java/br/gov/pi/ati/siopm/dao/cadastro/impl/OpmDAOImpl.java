package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.OpmDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Opm;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OpmDAOImpl extends BaseDAOImpl<Opm> implements OpmDAO {

    @Override
    public Class getEntityClass() {
        return Opm.class;
    }

}
