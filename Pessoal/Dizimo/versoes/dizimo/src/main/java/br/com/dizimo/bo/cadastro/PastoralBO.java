package br.com.dizimo.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.dizimo.dao.cadastro.PastoralDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dizimo.modelo.cadastro.Pastoral;
import com.xpert.core.validation.UniqueFields;

/**
 *
 * @author Juniel
 */
@Stateless
public class PastoralBO extends AbstractBusinessObject<Pastoral> {

    @EJB
    private PastoralDAO pastoralDAO;

    @Override
    public PastoralDAO getDAO() {
        return pastoralDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return new UniqueFields().add("nome");
    }

    @Override
    public void validate(Pastoral pastoral) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
