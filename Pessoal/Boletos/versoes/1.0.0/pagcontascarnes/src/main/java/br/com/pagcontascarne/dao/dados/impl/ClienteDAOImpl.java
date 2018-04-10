package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.ClienteDAO;
import br.com.pagcontascarne.modelo.dados.Cliente;
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
