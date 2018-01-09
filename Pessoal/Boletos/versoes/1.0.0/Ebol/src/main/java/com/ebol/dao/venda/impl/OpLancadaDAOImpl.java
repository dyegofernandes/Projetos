package com.ebol.dao.venda.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.venda.OpLancadaDAO;
import com.ebol.modelo.venda.OpLancada;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OpLancadaDAOImpl extends BaseDAOImpl<OpLancada> implements OpLancadaDAO {

    @Override
    public Class getEntityClass() {
        return OpLancada.class;
    }

}
