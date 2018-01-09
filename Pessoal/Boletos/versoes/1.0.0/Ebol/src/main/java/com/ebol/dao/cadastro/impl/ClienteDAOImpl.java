package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.ClienteDAO;
import com.ebol.modelo.cadastro.Cliente;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ClienteDAOImpl extends BaseDAOImpl<Cliente> implements ClienteDAO {

    @Override
    public Class getEntityClass() {
        return Cliente.class;
    }

}
