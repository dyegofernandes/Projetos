package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.LojaDAO;
import com.ebol.modelo.cadastro.Loja;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class LojaDAOImpl extends BaseDAOImpl<Loja> implements LojaDAO {

    @Override
    public Class getEntityClass() {
        return Loja.class;
    }

}
