package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.OrgaoRecebedorDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.OrgaoRecebedor;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrgaoRecebedorBO extends AbstractBusinessObject<OrgaoRecebedor> {

    @EJB
    private OrgaoRecebedorDAO orgaoRecebedorDAO;
    
    @Override
    public OrgaoRecebedorDAO getDAO() {
        return orgaoRecebedorDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(OrgaoRecebedor orgaoRecebedor) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
