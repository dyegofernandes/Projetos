package br.com.dizimo.dao.cadastro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.cadastro.PastoralDAO;
import br.com.dizimo.modelo.cadastro.Pastoral;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PastoralDAOImpl extends BaseDAOImpl<Pastoral> implements PastoralDAO {

    @Override
    public Class getEntityClass() {
        return Pastoral.class;
    }

}
