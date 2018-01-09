package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.FuncaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.Funcao;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class FuncaoBO extends AbstractBusinessObject<Funcao> {

    @EJB
    private FuncaoDAO funcaoDAO;
    
    @Override
    public FuncaoDAO getDAO() {
        return funcaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(Funcao funcao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
