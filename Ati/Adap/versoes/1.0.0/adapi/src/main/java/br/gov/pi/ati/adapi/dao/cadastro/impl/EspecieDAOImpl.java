package br.gov.pi.ati.adapi.dao.cadastro.impl;

import br.gov.pi.ati.adapi.application.BaseDAOImpl;
import br.gov.pi.ati.adapi.dao.cadastro.EspecieDAO;
import br.gov.pi.ati.adapi.modelo.cadastro.Especie;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class EspecieDAOImpl extends BaseDAOImpl<Especie> implements EspecieDAO {

    @Override
    public Class getEntityClass() {
        return Especie.class;
    }

}
