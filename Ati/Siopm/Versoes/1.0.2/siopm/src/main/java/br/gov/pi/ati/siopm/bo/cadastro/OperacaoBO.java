package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.OperacaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.Operacao;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class OperacaoBO extends AbstractBusinessObject<Operacao> {

    @EJB
    private OperacaoDAO operacaoDAO;

    @Override
    public OperacaoDAO getDAO() {
        return operacaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo");
    }

    @Override
    public void validate(Operacao operacao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
