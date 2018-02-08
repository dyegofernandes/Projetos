package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.MetaProdutoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.MetaProduto;

/**
 *
 * @author Juniel
 */
@Stateless
public class MetaProdutoBO extends AbstractBusinessObject<MetaProduto> {

    @EJB
    private MetaProdutoDAO metaProdutoDAO;
    
    @Override
    public MetaProdutoDAO getDAO() {
        return metaProdutoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(MetaProduto metaProduto) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
