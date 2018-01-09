package br.gov.pi.ati.agendacultural.bo.eventos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.agendacultural.dao.eventos.EventoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.agendacultural.modelo.eventos.Evento;

/**
 *
 * @author Juniel
 */
@Stateless
public class EventoBO extends AbstractBusinessObject<Evento> {

    @EJB
    private EventoDAO eventoDAO;

    @Override
    public EventoDAO getDAO() {
        return eventoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Evento evento) throws BusinessException {
        if (evento.getDataInicio().after(evento.getDataFim())) {
            throw new BusinessException("Data inicial não pode ser posterior a data final do Evento!");
        }

        if (evento.getCategorias().size() < 1) {
            throw new BusinessException("O evento deve possuir uma ou mais categorias!");
        }

        if (evento.getValores().size() < 1) {
            throw new BusinessException("O evento deve possuir um ou mais valores!");
        }
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
