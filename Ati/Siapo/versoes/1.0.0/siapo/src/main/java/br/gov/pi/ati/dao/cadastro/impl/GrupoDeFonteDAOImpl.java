package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.GrupoDeFonteDAO;
import br.gov.pi.ati.modelo.cadastro.GrupoDeFonte;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoDeFonteDAOImpl extends BaseDAOImpl<GrupoDeFonte> implements GrupoDeFonteDAO {

    @Override
    public Class getEntityClass() {
        return GrupoDeFonte.class;
    }

}
