package br.com.politicalpartysystem.dao.cadastro.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.cadastro.PhoneDAO;
import br.com.politicalpartysystem.modelo.cadastro.Phone;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PhoneDAOImpl extends BaseDAOImpl<Phone> implements PhoneDAO {

    @Override
    public Class getEntityClass() {
        return Phone.class;
    }

}
