package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.GrupoDeDespesaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.GrupoDeDespesa;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoDeDespesaBO extends AbstractBusinessObject<GrupoDeDespesa> {

    @EJB
    private GrupoDeDespesaDAO grupoDeDespesaDAO;
    
    @Override
    public GrupoDeDespesaDAO getDAO() {
        return grupoDeDespesaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(GrupoDeDespesa grupoDeDespesa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
