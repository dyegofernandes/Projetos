package br.com.dizimo.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.dizimo.dao.cadastro.MembroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dizimo.modelo.cadastro.Membro;

/**
 *
 * @author Juniel
 */
@Stateless
public class MembroBO extends AbstractBusinessObject<Membro> {

    @EJB
    private MembroDAO membroDAO;
    
    @Override
    public MembroDAO getDAO() {
        return membroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Membro membro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
