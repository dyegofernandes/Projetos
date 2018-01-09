package br.com.jsoft.centralfinanceira.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.financeiro.LancamentosDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.financeiro.Lancamentos;

/**
 *
 * @author Juniel
 */
@Stateless
public class LancamentosBO extends AbstractBusinessObject<Lancamentos> {

    @EJB
    private LancamentosDAO lancamentosDAO;
    
    @Override
    public LancamentosDAO getDAO() {
        return lancamentosDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Lancamentos lancamentos) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
