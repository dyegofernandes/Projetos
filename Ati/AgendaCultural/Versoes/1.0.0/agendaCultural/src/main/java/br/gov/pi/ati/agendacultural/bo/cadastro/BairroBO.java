package br.gov.pi.ati.agendacultural.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.agendacultural.dao.cadastro.BairroDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Bairro;

/**
 *
 * @author Juniel
 */
@Stateless
public class BairroBO extends AbstractBusinessObject<Bairro> {

    @EJB
    private BairroDAO bairroDAO;
    
    @Override
    public BairroDAO getDAO() {
        return bairroDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Bairro bairro) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
