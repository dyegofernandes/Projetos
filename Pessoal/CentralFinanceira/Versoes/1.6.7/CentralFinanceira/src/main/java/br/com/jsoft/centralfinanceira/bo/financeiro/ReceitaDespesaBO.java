package br.com.jsoft.centralfinanceira.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.financeiro.ReceitaDespesaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ReceitaDespesa;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class ReceitaDespesaBO extends AbstractBusinessObject<ReceitaDespesa> {

    @EJB
    private ReceitaDespesaDAO receitaDespesaDAO;

    @Override
    public ReceitaDespesaDAO getDAO() {
        return receitaDespesaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("empresa", "receitaDespesaMae", "nome", "natureza");
    }

    @Override
    public void validate(ReceitaDespesa receitaDespesa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
