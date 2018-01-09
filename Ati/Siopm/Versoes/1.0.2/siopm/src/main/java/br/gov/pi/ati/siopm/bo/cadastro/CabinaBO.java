package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.CabinaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Cabina;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class CabinaBO extends AbstractBusinessObject<Cabina> {

    @EJB
    private CabinaDAO cabinaDAO;
    
    @Override
    public CabinaDAO getDAO() {
        return cabinaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("cidade", "numero");
    }

    @Override
    public void validate(Cabina cabina) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
