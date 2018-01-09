package br.gov.pi.ati.adapi.dao.cadastro.impl;

import br.gov.pi.ati.adapi.application.BaseDAOImpl;
import br.gov.pi.ati.adapi.dao.cadastro.AnimalDAO;
import br.gov.pi.ati.adapi.modelo.cadastro.Animal;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AnimalDAOImpl extends BaseDAOImpl<Animal> implements AnimalDAO {

    @Override
    public Class getEntityClass() {
        return Animal.class;
    }

}
