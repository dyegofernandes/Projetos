package br.com.dizimo.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.dizimo.dao.cadastro.EstadoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dizimo.modelo.cadastro.Estado;

/**
 *
 * @author Juniel
 */
@Stateless
public class EstadoBO extends AbstractBusinessObject<Estado> {

    @EJB
    private EstadoDAO estadoDAO;
    
    @Override
    public EstadoDAO getDAO() {
        return estadoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Estado estado) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
