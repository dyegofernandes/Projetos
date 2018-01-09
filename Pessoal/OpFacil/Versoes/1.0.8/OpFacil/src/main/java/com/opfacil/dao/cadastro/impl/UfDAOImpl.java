package com.opfacil.dao.cadastro.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.cadastro.UfDAO;
import com.opfacil.modelo.cadastro.Uf;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class UfDAOImpl extends BaseDAOImpl<Uf> implements UfDAO {

    @Override
    public Class getEntityClass() {
        return Uf.class;
    }

}
