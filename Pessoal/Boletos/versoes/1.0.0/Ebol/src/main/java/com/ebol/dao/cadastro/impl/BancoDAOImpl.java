package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.BancoDAO;
import com.ebol.modelo.cadastro.Banco;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class BancoDAOImpl extends BaseDAOImpl<Banco> implements BancoDAO {

    @Override
    public Class getEntityClass() {
        return Banco.class;
    }

}
