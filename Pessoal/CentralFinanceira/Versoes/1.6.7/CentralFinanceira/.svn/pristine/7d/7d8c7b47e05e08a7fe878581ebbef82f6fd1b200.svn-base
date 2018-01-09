package br.com.jsoft.centralfinanceira.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.financeiro.ContasAPagarDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagar;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class ContasAPagarBO extends AbstractBusinessObject<ContasAPagar> {

    @EJB
    private ContasAPagarDAO contasAPagarDAO;
    
    @Override
    public ContasAPagarDAO getDAO() {
        return contasAPagarDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ContasAPagar contasAPagar) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
