package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.NaturezaDeDespesaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class NaturezaDeDespesaBO extends AbstractBusinessObject<NaturezaDeDespesa> {

    @EJB
    private NaturezaDeDespesaDAO naturezaDeDespesaDAO;
    
    @Override
    public NaturezaDeDespesaDAO getDAO() {
        return naturezaDeDespesaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(NaturezaDeDespesa naturezaDeDespesa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
