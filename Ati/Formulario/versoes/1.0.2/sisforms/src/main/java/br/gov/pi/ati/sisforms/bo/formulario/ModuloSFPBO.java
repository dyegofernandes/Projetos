package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.ModuloSFPDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFP;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModuloSFPBO extends AbstractBusinessObject<ModuloSFP> {

    @EJB
    private ModuloSFPDAO moduloSFPDAO;
    
    @Override
    public ModuloSFPDAO getDAO() {
        return moduloSFPDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ModuloSFP moduloSFP) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
