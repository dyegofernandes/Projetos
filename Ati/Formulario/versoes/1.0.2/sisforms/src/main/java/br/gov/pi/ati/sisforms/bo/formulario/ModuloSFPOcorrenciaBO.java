package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.ModuloSFPOcorrenciaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFPOcorrencia;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModuloSFPOcorrenciaBO extends AbstractBusinessObject<ModuloSFPOcorrencia> {

    @EJB
    private ModuloSFPOcorrenciaDAO moduloSFPOcorrenciaDAO;
    
    @Override
    public ModuloSFPOcorrenciaDAO getDAO() {
        return moduloSFPOcorrenciaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ModuloSFPOcorrencia moduloSFPOcorrencia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
