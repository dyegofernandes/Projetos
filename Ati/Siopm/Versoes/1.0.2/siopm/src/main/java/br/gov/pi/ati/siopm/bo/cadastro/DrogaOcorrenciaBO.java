package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.DrogaOcorrenciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrencia;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class DrogaOcorrenciaBO extends AbstractBusinessObject<DrogaOcorrencia> {

    @EJB
    private DrogaOcorrenciaDAO drogaOcorrenciaDAO;
    
    @Override
    public DrogaOcorrenciaDAO getDAO() {
        return drogaOcorrenciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome");
    }

    @Override
    public void validate(DrogaOcorrencia drogaOcorrencia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
