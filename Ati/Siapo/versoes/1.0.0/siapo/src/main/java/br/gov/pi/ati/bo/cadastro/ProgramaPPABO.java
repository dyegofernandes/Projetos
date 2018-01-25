package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.ProgramaPPADAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.ProgramaPPA;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProgramaPPABO extends AbstractBusinessObject<ProgramaPPA> {

    @EJB
    private ProgramaPPADAO programaPPADAO;
    
    @Override
    public ProgramaPPADAO getDAO() {
        return programaPPADAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ProgramaPPA programaPPA) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
