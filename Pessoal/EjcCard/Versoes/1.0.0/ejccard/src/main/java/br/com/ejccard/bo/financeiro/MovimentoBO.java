package br.com.ejccard.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.ejccard.dao.financeiro.MovimentoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.ejccard.modelo.financeiro.Movimento;

/**
 *
 * @author Juniel
 */
@Stateless
public class MovimentoBO extends AbstractBusinessObject<Movimento> {

    @EJB
    private MovimentoDAO movimentoDAO;
    
    @Override
    public MovimentoDAO getDAO() {
        return movimentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Movimento movimento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
