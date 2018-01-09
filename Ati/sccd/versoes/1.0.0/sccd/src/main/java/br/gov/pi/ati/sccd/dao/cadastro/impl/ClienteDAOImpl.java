package br.gov.pi.ati.sccd.dao.cadastro.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.cadastro.ClienteDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.Cliente;
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
