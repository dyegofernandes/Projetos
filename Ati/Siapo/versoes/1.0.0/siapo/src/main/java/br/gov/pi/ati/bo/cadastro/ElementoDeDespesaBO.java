package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.ElementoDeDespesaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.ElementoDeDespesa;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class ElementoDeDespesaBO extends AbstractBusinessObject<ElementoDeDespesa> {

    @EJB
    private ElementoDeDespesaDAO elementoDeDespesaDAO;

    @Override
    public ElementoDeDespesaDAO getDAO() {
        return elementoDeDespesaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(ElementoDeDespesa elementoDeDespesa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
