package br.com.dizimo.dao.cadastro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.cadastro.SedeDAO;
import br.com.dizimo.modelo.cadastro.Sede;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SedeDAOImpl extends BaseDAOImpl<Sede> implements SedeDAO {

    @Override
    public Class getEntityClass() {
        return Sede.class;
    }

}
