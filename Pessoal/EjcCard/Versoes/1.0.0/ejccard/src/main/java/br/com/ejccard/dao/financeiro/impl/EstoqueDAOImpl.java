package br.com.ejccard.dao.financeiro.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.financeiro.EstoqueDAO;
import br.com.ejccard.modelo.financeiro.Estoque;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class EstoqueDAOImpl extends BaseDAOImpl<Estoque> implements EstoqueDAO {

    @Override
    public Class getEntityClass() {
        return Estoque.class;
    }

}
