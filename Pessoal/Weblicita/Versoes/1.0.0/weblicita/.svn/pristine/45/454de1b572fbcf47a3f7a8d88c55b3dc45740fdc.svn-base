package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.weblicita.dao.cadastro.UnidadeDeMedidaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.UnidadeDeMedida;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeDeMedidaBO extends AbstractBusinessObject<UnidadeDeMedida> {

    @EJB
    private UnidadeDeMedidaDAO unidadeDeMedidaDAO;
    
    @Override
    public UnidadeDeMedidaDAO getDAO() {
        return unidadeDeMedidaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(UnidadeDeMedida unidadeDeMedida) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
