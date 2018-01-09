package com.ebol.dao.venda.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.venda.VendaDAO;
import com.ebol.modelo.venda.Venda;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class VendaDAOImpl extends BaseDAOImpl<Venda> implements VendaDAO {

    @Override
    public Class getEntityClass() {
        return Venda.class;
    }

}
