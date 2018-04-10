package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.UfDAO;
import br.com.pagcontascarne.modelo.dados.Uf;
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
