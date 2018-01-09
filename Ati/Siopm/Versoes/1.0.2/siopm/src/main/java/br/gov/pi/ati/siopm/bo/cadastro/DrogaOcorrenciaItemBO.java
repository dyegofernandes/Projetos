package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.DrogaOcorrenciaItemDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrenciaItem;

/**
 *
 * @author Juniel
 */
@Stateless
public class DrogaOcorrenciaItemBO extends AbstractBusinessObject<DrogaOcorrenciaItem> {

    @EJB
    private DrogaOcorrenciaItemDAO drogaOcorrenciaItemDAO;
    
    @Override
    public DrogaOcorrenciaItemDAO getDAO() {
        return drogaOcorrenciaItemDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(DrogaOcorrenciaItem drogaOcorrenciaItem) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
