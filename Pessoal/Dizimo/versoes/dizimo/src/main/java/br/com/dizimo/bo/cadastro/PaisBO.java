package br.com.dizimo.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.dizimo.dao.cadastro.PaisDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dizimo.modelo.cadastro.Pais;

/**
 *
 * @author Juniel
 */
@Stateless
public class PaisBO extends AbstractBusinessObject<Pais> {

    @EJB
    private PaisDAO paisDAO;
    
    @Override
    public PaisDAO getDAO() {
        return paisDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Pais pais) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
