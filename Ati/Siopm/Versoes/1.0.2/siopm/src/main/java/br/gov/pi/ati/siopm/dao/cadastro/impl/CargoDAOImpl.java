package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.CargoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Cargo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CargoDAOImpl extends BaseDAOImpl<Cargo> implements CargoDAO {

    @Override
    public Class getEntityClass() {
        return Cargo.class;
    }

}
