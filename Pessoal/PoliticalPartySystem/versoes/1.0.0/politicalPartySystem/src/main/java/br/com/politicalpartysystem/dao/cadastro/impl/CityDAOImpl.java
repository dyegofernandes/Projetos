package br.com.politicalpartysystem.dao.cadastro.impl;

import br.com.politicalpartysystem.application.BaseDAOImpl;
import br.com.politicalpartysystem.dao.cadastro.CityDAO;
import br.com.politicalpartysystem.modelo.cadastro.City;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CityDAOImpl extends BaseDAOImpl<City> implements CityDAO {

    @Override
    public Class getEntityClass() {
        return City.class;
    }

}
