package br.gov.pi.ati.sisforms.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.cadastro.TipoCertificadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.cadastro.TipoCertificado;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoCertificadoBO extends AbstractBusinessObject<TipoCertificado> {

    @EJB
    private TipoCertificadoDAO tipoCertificadoDAO;
    
    @Override
    public TipoCertificadoDAO getDAO() {
        return tipoCertificadoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TipoCertificado tipoCertificado) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
