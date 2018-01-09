package com.ebol.dao.venda.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.venda.CreditoDAO;
import com.ebol.modelo.venda.Credito;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CreditoDAOImpl extends BaseDAOImpl<Credito> implements CreditoDAO {

    @Override
    public Class getEntityClass() {
        return Credito.class;
    }

}
