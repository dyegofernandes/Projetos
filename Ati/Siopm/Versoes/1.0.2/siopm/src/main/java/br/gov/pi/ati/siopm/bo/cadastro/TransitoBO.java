package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.TransitoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Transito;

/**
 *
 * @author Juniel
 */
@Stateless
public class TransitoBO extends AbstractBusinessObject<Transito> {

    @EJB
    private TransitoDAO transitoDAO;
    
    @Override
    public TransitoDAO getDAO() {
        return transitoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Transito transito) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
