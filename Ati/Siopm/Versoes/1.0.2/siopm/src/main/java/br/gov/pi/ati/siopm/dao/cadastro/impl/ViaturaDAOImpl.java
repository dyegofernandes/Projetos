package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.ViaturaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Viatura;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ViaturaDAOImpl extends BaseDAOImpl<Viatura> implements ViaturaDAO {

    @Override
    public Class getEntityClass() {
        return Viatura.class;
    }

}
