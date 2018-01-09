package br.gov.pi.ati.sisforms.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.cadastro.OrgaoCertificadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.cadastro.OrgaoCertificado;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrgaoCertificadoBO extends AbstractBusinessObject<OrgaoCertificado> {

    @EJB
    private OrgaoCertificadoDAO orgaoCertificadoDAO;
    
    @Override
    public OrgaoCertificadoDAO getDAO() {
        return orgaoCertificadoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(OrgaoCertificado orgaoCertificado) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
