package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.NaturezaDeReceitaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeReceita;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class NaturezaDeReceitaBO extends AbstractBusinessObject<NaturezaDeReceita> {

    @EJB
    private NaturezaDeReceitaDAO naturezaDeReceitaDAO;
    
    @Override
    public NaturezaDeReceitaDAO getDAO() {
        return naturezaDeReceitaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(NaturezaDeReceita naturezaDeReceita) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
