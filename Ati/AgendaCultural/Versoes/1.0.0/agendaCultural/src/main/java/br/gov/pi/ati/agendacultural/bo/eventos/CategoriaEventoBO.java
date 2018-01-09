package br.gov.pi.ati.agendacultural.bo.eventos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.agendacultural.dao.eventos.CategoriaEventoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.agendacultural.modelo.eventos.CategoriaEvento;

/**
 *
 * @author Juniel
 */
@Stateless
public class CategoriaEventoBO extends AbstractBusinessObject<CategoriaEvento> {

    @EJB
    private CategoriaEventoDAO categoriaEventoDAO;
    
    @Override
    public CategoriaEventoDAO getDAO() {
        return categoriaEventoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(CategoriaEvento categoriaEvento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
