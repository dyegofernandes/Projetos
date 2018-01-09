package com.ebol.dao.venda.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.venda.Item_VendidoDAO;
import com.ebol.modelo.venda.Item_Vendido;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class Item_VendidoDAOImpl extends BaseDAOImpl<Item_Vendido> implements Item_VendidoDAO {

    @Override
    public Class getEntityClass() {
        return Item_Vendido.class;
    }

}
