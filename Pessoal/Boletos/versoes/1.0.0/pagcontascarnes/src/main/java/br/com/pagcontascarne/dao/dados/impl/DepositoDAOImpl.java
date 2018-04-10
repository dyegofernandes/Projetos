package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.DepositoDAO;
import br.com.pagcontascarne.modelo.dados.Deposito;
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
