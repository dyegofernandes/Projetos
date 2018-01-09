package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.CargoDAO;
import br.gov.pi.siste.modelo.cadastro.Cargo;
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
