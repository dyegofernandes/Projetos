package br.com.ejccard.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.ejccard.dao.financeiro.EstoqueDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.ejccard.modelo.financeiro.Estoque;

/**
 *
 * @author Juniel
 */
@Stateless
public class EstoqueBO extends AbstractBusinessObject<Estoque> {

    @EJB
    private EstoqueDAO estoqueDAO;
    
    @Override
    public EstoqueDAO getDAO() {
        return estoqueDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Estoque estoque) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
