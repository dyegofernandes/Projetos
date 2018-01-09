package br.gov.pi.ati.agendacultural.dao.cadastro.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.cadastro.LocalEventoDAO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.LocalEvento;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class LocalEventoDAOImpl extends BaseDAOImpl<LocalEvento> implements LocalEventoDAO {

    @Override
    public Class getEntityClass() {
        return LocalEvento.class;
    }

}
