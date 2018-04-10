package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.FranquiaDAO;
import br.com.pagcontascarne.modelo.dados.Franquia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FranquiaDAOImpl extends BaseDAOImpl<Franquia> implements FranquiaDAO {

    @Override
    public Class getEntityClass() {
        return Franquia.class;
    }

}
