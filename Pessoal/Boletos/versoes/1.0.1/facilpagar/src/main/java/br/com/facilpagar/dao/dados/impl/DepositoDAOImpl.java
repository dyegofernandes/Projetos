package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.DepositoDAO;
import br.com.facilpagar.modelo.dados.Deposito;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DepositoDAOImpl extends BaseDAOImpl<Deposito> implements DepositoDAO {

    @Override
    public Class getEntityClass() {
        return Deposito.class;
    }

}
