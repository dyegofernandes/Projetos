package br.gov.pi.ati.agendacultural.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.agendacultural.dao.cadastro.AssentoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Assento;

/**
 *
 * @author Juniel
 */
@Stateless
public class AssentoBO extends AbstractBusinessObject<Assento> {

    @EJB
    private AssentoDAO assentoDAO;
    
    @Override
    public AssentoDAO getDAO() {
        return assentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Assento assento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
