package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.ControleDeCertificadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.ControleDeCertificado;

/**
 *
 * @author Juniel
 */
@Stateless
public class ControleDeCertificadoBO extends AbstractBusinessObject<ControleDeCertificado> {

    @EJB
    private ControleDeCertificadoDAO controleDeCertificadoDAO;
    
    @Override
    public ControleDeCertificadoDAO getDAO() {
        return controleDeCertificadoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ControleDeCertificado controleDeCertificado) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
