package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.SubFuncaoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.SubFuncao;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class SubFuncaoBO extends AbstractBusinessObject<SubFuncao> {

    @EJB
    private SubFuncaoDAO subFuncaoDAO;
    
    @Override
    public SubFuncaoDAO getDAO() {
        return subFuncaoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("codigo,funcao").add("nome,funcao");
    }

    @Override
    public void validate(SubFuncao subFuncao) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
