package br.com.ejccard.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.ejccard.dao.cadastro.MembroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.ejccard.modelo.cadastro.Membro;
import com.xpert.core.validation.UniqueFields;

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
        return new UniqueFields().add("nome","nomeUsual","equipe");
    }

    @Override
    public void validate(Membro membro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
