package br.gov.pi.ati.sisforms.bo.servicos;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.servicos.ReservaLocalDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;

/**
 *
 * @author Juniel
 */
@Stateless
public class ReservaLocalBO extends AbstractBusinessObject<ReservaLocal> {

    @EJB
    private ReservaLocalDAO reservaLocalDAO;
    
    @Override
    public ReservaLocalDAO getDAO() {
        return reservaLocalDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ReservaLocal reservaLocal) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
