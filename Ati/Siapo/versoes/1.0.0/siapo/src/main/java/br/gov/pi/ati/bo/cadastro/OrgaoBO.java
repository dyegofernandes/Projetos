package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.OrgaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.Orgao;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrgaoBO extends AbstractBusinessObject<Orgao> {

    @EJB
    private OrgaoDAO orgaoDAO;
    
    @Override
    public OrgaoDAO getDAO() {
        return orgaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome").add("sigla");
    }

    @Override
    public void validate(Orgao orgao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
