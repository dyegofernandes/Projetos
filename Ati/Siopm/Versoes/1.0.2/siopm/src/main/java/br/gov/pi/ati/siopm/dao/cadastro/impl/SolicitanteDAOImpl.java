package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.SolicitanteDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Solicitante;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SolicitanteDAOImpl extends BaseDAOImpl<Solicitante> implements SolicitanteDAO {

    @Override
    public Class getEntityClass() {
        return Solicitante.class;
    }

}
