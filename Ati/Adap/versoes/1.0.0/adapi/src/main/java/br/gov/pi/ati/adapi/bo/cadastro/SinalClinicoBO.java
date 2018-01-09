package br.gov.pi.ati.adapi.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.adapi.dao.cadastro.SinalClinicoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.adapi.modelo.cadastro.SinalClinico;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class SinalClinicoBO extends AbstractBusinessObject<SinalClinico> {

    @EJB
    private SinalClinicoDAO sinalClinicoDAO;
    
    @Override
    public SinalClinicoDAO getDAO() {
        return sinalClinicoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("termoTecnico").add("termoPopular");
    }

    @Override
    public void validate(SinalClinico sinalClinico) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
