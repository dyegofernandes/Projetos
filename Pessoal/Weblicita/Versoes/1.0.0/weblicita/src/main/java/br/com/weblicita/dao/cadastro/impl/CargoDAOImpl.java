package br.com.weblicita.dao.cadastro.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.cadastro.CargoDAO;
import br.com.weblicita.modelo.cadastro.Cargo;
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
