package br.gov.pi.ati.bo.orcamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.orcamento.DotacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.orcamento.Dotacao;

/**
 *
 * @author Juniel
 */
@Stateless
public class DotacaoBO extends AbstractBusinessObject<Dotacao> {

    @EJB
    private DotacaoDAO dotacaoDAO;
    
    @Override
    public DotacaoDAO getDAO() {
        return dotacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Dotacao dotacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
