package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.ClassificacaoDaDespesaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.ClassificacaoDaDespesa;

/**
 *
 * @author Juniel
 */
@Stateless
public class ClassificacaoDaDespesaBO extends AbstractBusinessObject<ClassificacaoDaDespesa> {

    @EJB
    private ClassificacaoDaDespesaDAO classificacaoDaDespesaDAO;
    
    @Override
    public ClassificacaoDaDespesaDAO getDAO() {
        return classificacaoDaDespesaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ClassificacaoDaDespesa classificacaoDaDespesa) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
