package br.gov.pi.siste.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.siste.dao.cadastro.RgDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.siste.modelo.cadastro.Rg;

/**
 *
 * @author Juniel
 */
@Stateless
public class RgBO extends AbstractBusinessObject<Rg> {

    @EJB
    private RgDAO DAO;
    
    @Override
    public RgDAO getDAO() {
        return DAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Rg rg) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
