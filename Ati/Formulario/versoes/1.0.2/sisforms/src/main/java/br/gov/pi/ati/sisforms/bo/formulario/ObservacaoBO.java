package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.ObservacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.Observacao;

/**
 *
 * @author Juniel
 */
@Stateless
public class ObservacaoBO extends AbstractBusinessObject<Observacao> {

    @EJB
    private ObservacaoDAO observacaoDAO;
    
    @Override
    public ObservacaoDAO getDAO() {
        return observacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Observacao observacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
