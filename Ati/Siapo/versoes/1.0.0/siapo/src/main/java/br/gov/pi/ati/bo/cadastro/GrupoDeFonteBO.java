package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.GrupoDeFonteDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.GrupoDeFonte;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoDeFonteBO extends AbstractBusinessObject<GrupoDeFonte> {

    @EJB
    private GrupoDeFonteDAO grupoDeFonteDAO;
    
    @Override
    public GrupoDeFonteDAO getDAO() {
        return grupoDeFonteDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(GrupoDeFonte grupoDeFonte) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
