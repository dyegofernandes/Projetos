package br.com.jsoft.centralfinanceira.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.financeiro.ContasAPagarVencimentosDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentos;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class ContasAPagarVencimentosBO extends AbstractBusinessObject<ContasAPagarVencimentos> {

    @EJB
    private ContasAPagarVencimentosDAO contasAPagarVencimentosDAO;
    
    @Override
    public ContasAPagarVencimentosDAO getDAO() {
        return contasAPagarVencimentosDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ContasAPagarVencimentos contasAPagarVencimentos) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
