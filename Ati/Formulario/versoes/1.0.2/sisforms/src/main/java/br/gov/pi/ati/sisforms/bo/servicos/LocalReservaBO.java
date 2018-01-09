package br.gov.pi.ati.sisforms.bo.servicos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.servicos.LocalReservaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;

/**
 *
 * @author Juniel
 */
@Stateless
public class LocalReservaBO extends AbstractBusinessObject<LocalReserva> {

    @EJB
    private LocalReservaDAO localReservaDAO;
    
    @Override
    public LocalReservaDAO getDAO() {
        return localReservaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(LocalReserva localReserva) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
