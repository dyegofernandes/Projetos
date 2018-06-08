package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.UfDAO;
import br.com.facilpagar.modelo.dados.Uf;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UfDAOImpl extends BaseDAOImpl<Uf> implements UfDAO {

    @Override
    public Class getEntityClass() {
        return Uf.class;
    }

}
