package br.gov.pi.ati.agendacultural.dao.eventos;

import com.xpert.persistence.dao.BaseDAO;
import br.gov.pi.ati.agendacultural.modelo.eventos.Evento;
import javax.ejb.Local;

/**
 *
 * @author Juniel
 */
@Local
public interface EventoDAO extends BaseDAO<Evento> {
    
}
