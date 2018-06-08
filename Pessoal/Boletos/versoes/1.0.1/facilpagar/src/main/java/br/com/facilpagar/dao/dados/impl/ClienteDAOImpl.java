package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.ClienteDAO;
import br.com.facilpagar.modelo.dados.Cliente;
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
