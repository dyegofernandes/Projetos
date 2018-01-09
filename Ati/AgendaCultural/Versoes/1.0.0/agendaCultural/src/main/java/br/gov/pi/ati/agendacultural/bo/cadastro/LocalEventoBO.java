package br.gov.pi.ati.agendacultural.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.agendacultural.dao.cadastro.LocalEventoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.agendacultural.modelo.cadastro.LocalEvento;

/**
 *
 * @author Juniel
 */
@Stateless
public class LocalEventoBO extends AbstractBusinessObject<LocalEvento> {

    @EJB
    private LocalEventoDAO localEventoDAO;
    
    @Override
    public LocalEventoDAO getDAO() {
        return localEventoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(LocalEvento localEvento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
