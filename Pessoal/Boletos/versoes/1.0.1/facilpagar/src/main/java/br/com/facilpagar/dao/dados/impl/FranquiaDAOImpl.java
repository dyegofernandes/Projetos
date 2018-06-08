package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.FranquiaDAO;
import br.com.facilpagar.modelo.dados.Franquia;
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
