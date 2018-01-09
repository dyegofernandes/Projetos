package com.ebol.dao.venda.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.venda.ItemDAO;
import com.ebol.modelo.venda.Item;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemDAOImpl extends BaseDAOImpl<Item> implements ItemDAO {

    @Override
    public Class getEntityClass() {
        return Item.class;
    }

}
