package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.AreaTematicaDAO;
import br.gov.pi.ati.modelo.cadastro.AreaTematica;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AreaTematicaDAOImpl extends BaseDAOImpl<AreaTematica> implements AreaTematicaDAO {

    @Override
    public Class getEntityClass() {
        return AreaTematica.class;
    }

}
