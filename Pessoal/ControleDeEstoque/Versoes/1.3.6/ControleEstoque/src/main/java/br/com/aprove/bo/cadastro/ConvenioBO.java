package br.com.aprove.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.cadastro.ConvenioDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.cadastro.Convenio;

/**
 *
 * @author juniel
 */
@Stateless
public class ConvenioBO extends AbstractBusinessObject<Convenio> {

    @EJB
    private ConvenioDAO convenioDAO;
    
    @Override
    public ConvenioDAO getDAO() {
        return convenioDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Convenio convenio) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
