package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.UnidadeGestoraDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.UnidadeGestora;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeGestoraBO extends AbstractBusinessObject<UnidadeGestora> {

    @EJB
    private UnidadeGestoraDAO unidadeGestoraDAO;
    
    @Override
    public UnidadeGestoraDAO getDAO() {
        return unidadeGestoraDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(UnidadeGestora unidadeGestora) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
