package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.ProgramacaoFinanceiraDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.ProgramacaoFinanceira;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProgramacaoFinanceiraBO extends AbstractBusinessObject<ProgramacaoFinanceira> {

    @EJB
    private ProgramacaoFinanceiraDAO programacaoFinanceiraDAO;
    
    @Override
    public ProgramacaoFinanceiraDAO getDAO() {
        return programacaoFinanceiraDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ProgramacaoFinanceira programacaoFinanceira) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
