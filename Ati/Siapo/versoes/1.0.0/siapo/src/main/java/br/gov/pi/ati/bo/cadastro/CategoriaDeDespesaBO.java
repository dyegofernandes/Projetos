package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.CategoriaDeDespesaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.CategoriaDeDespesa;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class CategoriaDeDespesaBO extends AbstractBusinessObject<CategoriaDeDespesa> {

    @EJB
    private CategoriaDeDespesaDAO categoriaDeDespesaDAO;
    
    @Override
    public CategoriaDeDespesaDAO getDAO() {
        return categoriaDeDespesaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(CategoriaDeDespesa categoriaDeDespesa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
