package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.PerfilSFPDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilSFP;

/**
 *
 * @author Juniel
 */
@Stateless
public class PerfilSFPBO extends AbstractBusinessObject<PerfilSFP> {

    @EJB
    private PerfilSFPDAO perfilSFPDAO;
    
    @Override
    public PerfilSFPDAO getDAO() {
        return perfilSFPDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PerfilSFP perfilSFP) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
