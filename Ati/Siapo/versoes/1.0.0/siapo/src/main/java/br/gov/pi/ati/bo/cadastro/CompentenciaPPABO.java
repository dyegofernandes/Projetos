package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.CompentenciaPPADAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.CompentenciaPPA;

/**
 *
 * @author Juniel
 */
@Stateless
public class CompentenciaPPABO extends AbstractBusinessObject<CompentenciaPPA> {

    @EJB
    private CompentenciaPPADAO compentenciaPPADAO;
    
    @Override
    public CompentenciaPPADAO getDAO() {
        return compentenciaPPADAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(CompentenciaPPA compentenciaPPA) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
