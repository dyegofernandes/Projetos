package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.DeliberacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.Deliberacao;

/**
 *
 * @author Juniel
 */
@Stateless
public class DeliberacaoBO extends AbstractBusinessObject<Deliberacao> {

    @EJB
    private DeliberacaoDAO deliberacaoDAO;
    
    @Override
    public DeliberacaoDAO getDAO() {
        return deliberacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Deliberacao deliberacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
