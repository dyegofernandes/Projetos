package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.ContaFinanceiraDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ContaFinanceira;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class ContaFinanceiraBO extends AbstractBusinessObject<ContaFinanceira> {

    @EJB
    private ContaFinanceiraDAO contaFinanceiraDAO;
    
    @Override
    public ContaFinanceiraDAO getDAO() {
        return contaFinanceiraDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa","nome");
    }

    @Override
    public void validate(ContaFinanceira contaFinanceira) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
