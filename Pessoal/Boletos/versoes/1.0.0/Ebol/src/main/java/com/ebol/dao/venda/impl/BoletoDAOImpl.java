package com.ebol.dao.venda.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.venda.BoletoDAO;
import com.ebol.modelo.venda.Boleto;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class BoletoDAOImpl extends BaseDAOImpl<Boleto> implements BoletoDAO {

    @Override
    public Class getEntityClass() {
        return Boleto.class;
    }

}
