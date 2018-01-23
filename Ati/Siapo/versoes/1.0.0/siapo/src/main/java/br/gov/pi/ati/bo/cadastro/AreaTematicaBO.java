package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.AreaTematicaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.AreaTematica;

/**
 *
 * @author Juniel
 */
@Stateless
public class AreaTematicaBO extends AbstractBusinessObject<AreaTematica> {

    @EJB
    private AreaTematicaDAO areaTematicaDAO;
    
    @Override
    public AreaTematicaDAO getDAO() {
        return areaTematicaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(AreaTematica areaTematica) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
