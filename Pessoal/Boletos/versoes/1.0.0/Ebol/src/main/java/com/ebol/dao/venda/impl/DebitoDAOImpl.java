package com.ebol.dao.venda.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.venda.DebitoDAO;
import com.ebol.modelo.venda.Debito;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DebitoDAOImpl extends BaseDAOImpl<Debito> implements DebitoDAO {

    @Override
    public Class getEntityClass() {
        return Debito.class;
    }

}
