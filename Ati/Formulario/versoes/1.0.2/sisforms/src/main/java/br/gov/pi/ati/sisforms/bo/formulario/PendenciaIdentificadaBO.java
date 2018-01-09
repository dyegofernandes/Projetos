package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.PendenciaIdentificadaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.PendenciaIdentificada;

/**
 *
 * @author Juniel
 */
@Stateless
public class PendenciaIdentificadaBO extends AbstractBusinessObject<PendenciaIdentificada> {

    @EJB
    private PendenciaIdentificadaDAO pendenciaIdentificadaDAO;
    
    @Override
    public PendenciaIdentificadaDAO getDAO() {
        return pendenciaIdentificadaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PendenciaIdentificada pendenciaIdentificada) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
