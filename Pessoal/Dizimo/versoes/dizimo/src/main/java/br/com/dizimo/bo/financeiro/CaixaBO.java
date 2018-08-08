package br.com.dizimo.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.dizimo.dao.financeiro.CaixaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dizimo.modelo.financeiro.Caixa;

/**
 *
 * @author Juniel
 */
@Stateless
public class CaixaBO extends AbstractBusinessObject<Caixa> {

    @EJB
    private CaixaDAO caixaDAO;
    
    @Override
    public CaixaDAO getDAO() {
        return caixaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Caixa caixa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
