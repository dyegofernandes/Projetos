package br.com.politicalpartysystem.dao.cadastro.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.cadastro.AddressDAO;
import br.com.politicalpartysystem.modelo.cadastro.Address;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AddressDAOImpl extends BaseDAOImpl<Address> implements AddressDAO {

    @Override
    public Class getEntityClass() {
        return Address.class;
    }

}
