package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.RequerimentoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.Requerimento;

/**
 *
 * @author Juniel
 */
@Stateless
public class RequerimentoBO extends AbstractBusinessObject<Requerimento> {

    @EJB
    private RequerimentoDAO requerimentoDAO;
    
    @Override
    public RequerimentoDAO getDAO() {
        return requerimentoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Requerimento requerimento) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
