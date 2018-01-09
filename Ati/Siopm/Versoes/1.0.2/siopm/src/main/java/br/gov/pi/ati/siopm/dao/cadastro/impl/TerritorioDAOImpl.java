package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.TerritorioDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Territorio;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TerritorioDAOImpl extends BaseDAOImpl<Territorio> implements TerritorioDAO {

    @Override
    public Class getEntityClass() {
        return Territorio.class;
    }

}
