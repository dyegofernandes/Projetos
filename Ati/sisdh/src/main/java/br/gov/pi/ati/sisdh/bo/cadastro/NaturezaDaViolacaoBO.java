package br.gov.pi.ati.sisdh.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sisdh.dao.cadastro.NaturezaDaViolacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sisdh.modelo.cadastro.NaturezaDaViolacao;

/**
 *
 * @author Juniel
 */
@Stateless
public class NaturezaDaViolacaoBO extends AbstractBusinessObject<NaturezaDaViolacao> {

    @EJB
    private NaturezaDaViolacaoDAO naturezaDaViolacaoDAO;
    
    @Override
    public NaturezaDaViolacaoDAO getDAO() {
        return naturezaDaViolacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(NaturezaDaViolacao naturezaDaViolacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
