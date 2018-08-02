package br.com.ejccard.dao.financeiro.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.financeiro.MovimentoDAO;
import br.com.ejccard.modelo.financeiro.Movimento;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MovimentoDAOImpl extends BaseDAOImpl<Movimento> implements MovimentoDAO {

    @Override
    public Class getEntityClass() {
        return Movimento.class;
    }

}
