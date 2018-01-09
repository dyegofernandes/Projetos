package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.PautaDaReuniaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.PautaDaReuniao;

/**
 *
 * @author Juniel
 */
@Stateless
public class PautaDaReuniaoBO extends AbstractBusinessObject<PautaDaReuniao> {

    @EJB
    private PautaDaReuniaoDAO pautaDaReuniaoDAO;
    
    @Override
    public PautaDaReuniaoDAO getDAO() {
        return pautaDaReuniaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(PautaDaReuniao pautaDaReuniao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
