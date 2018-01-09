package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.ArmaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Arma;

/**
 *
 * @author Juniel
 */
@Stateless
public class ArmaBO extends AbstractBusinessObject<Arma> {

    @EJB
    private ArmaDAO armaDAO;
    
    @Override
    public ArmaDAO getDAO() {
        return armaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Arma arma) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
