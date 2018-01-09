package br.com.jsoft.centralfinanceira.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.financeiro.ContasAPagarVencimentosBaixasDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentosBaixas;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContasAPagarVencimentosBaixasBO extends AbstractBusinessObject<ContasAPagarVencimentosBaixas> {

    @EJB
    private ContasAPagarVencimentosBaixasDAO contasAPagarVencimentosBaixasDAO;
    
    @Override
    public ContasAPagarVencimentosBaixasDAO getDAO() {
        return contasAPagarVencimentosBaixasDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ContasAPagarVencimentosBaixas contasAPagarVencimentosBaixas) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
