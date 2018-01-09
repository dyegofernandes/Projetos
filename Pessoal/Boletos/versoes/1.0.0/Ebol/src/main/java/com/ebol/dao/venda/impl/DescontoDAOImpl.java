package com.ebol.dao.venda.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.venda.DescontoDAO;
import com.ebol.modelo.venda.Desconto;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DescontoDAOImpl extends BaseDAOImpl<Desconto> implements DescontoDAO {

    @Override
    public Class getEntityClass() {
        return Desconto.class;
    }

}
