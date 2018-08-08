package br.com.dizimo.dao.financeiro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.financeiro.DizimoDAO;
import br.com.dizimo.modelo.financeiro.Dizimo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DizimoDAOImpl extends BaseDAOImpl<Dizimo> implements DizimoDAO {

    @Override
    public Class getEntityClass() {
        return Dizimo.class;
    }

}
