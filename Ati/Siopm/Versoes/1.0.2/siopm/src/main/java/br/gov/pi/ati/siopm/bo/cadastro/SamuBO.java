package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.SamuDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Samu;

/**
 *
 * @author Juniel
 */
@Stateless
public class SamuBO extends AbstractBusinessObject<Samu> {

    @EJB
    private SamuDAO samuDAO;
    
    @Override
    public SamuDAO getDAO() {
        return samuDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Samu samu) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
