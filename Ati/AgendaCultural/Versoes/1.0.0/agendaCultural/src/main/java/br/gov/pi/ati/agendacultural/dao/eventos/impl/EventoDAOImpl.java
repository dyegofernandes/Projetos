package br.gov.pi.ati.agendacultural.dao.eventos.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.eventos.EventoDAO;
import br.gov.pi.ati.agendacultural.modelo.eventos.Evento;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class EventoDAOImpl extends BaseDAOImpl<Evento> implements EventoDAO {

    @Override
    public Class getEntityClass() {
        return Evento.class;
    }

}
