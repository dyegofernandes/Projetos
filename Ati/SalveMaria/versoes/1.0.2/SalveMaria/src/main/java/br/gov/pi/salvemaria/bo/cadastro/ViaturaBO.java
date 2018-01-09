package br.gov.pi.salvemaria.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.salvemaria.dao.cadastro.ViaturaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.salvemaria.modelo.cadastro.Viatura;

/**
 *
 * @author Juniel
 */
@Stateless
public class ViaturaBO extends AbstractBusinessObject<Viatura> {

    @EJB
    private ViaturaDAO viaturaDAO;
    
    @Override
    public ViaturaDAO getDAO() {
        return viaturaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Viatura viatura) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
