package br.com.pagcontascarne.bo.dados;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.pagcontascarne.dao.dados.ContatoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.pagcontascarne.modelo.dados.Contato;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContatoBO extends AbstractBusinessObject<Contato> {

    @EJB
    private ContatoDAO contatoDAO;
    
    @Override
    public ContatoDAO getDAO() {
        return contatoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Contato contato) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
