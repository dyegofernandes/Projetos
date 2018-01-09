package br.gov.pi.ati.sisforms.bo.formulario;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisforms.dao.formulario.EncaminhamentoLGBTDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisforms.modelo.formulario.EncaminhamentoLGBT;

/**
 *
 * @author Juniel
 */
@Stateless
public class EncaminhamentoLGBTBO extends AbstractBusinessObject<EncaminhamentoLGBT> {

    @EJB
    private EncaminhamentoLGBTDAO encaminhamentoLGBTDAO;
    
    @Override
    public EncaminhamentoLGBTDAO getDAO() {
        return encaminhamentoLGBTDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(EncaminhamentoLGBT encaminhamentoLGBT) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
