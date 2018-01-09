package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.UfDAO;
import com.ebol.modelo.cadastro.Uf;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UfDAOImpl extends BaseDAOImpl<Uf> implements UfDAO {

    @Override
    public Class getEntityClass() {
        return Uf.class;
    }

}
