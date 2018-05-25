package br.gov.pi.ati.sisrh.bo.cadastro;

import br.gov.pi.ati.sisrh.dao.cadastro.EncaminhamentoLGBTDAO;
import br.gov.pi.ati.sisrh.modelo.cadastro.EncaminhamentoLGBT;
import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

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
