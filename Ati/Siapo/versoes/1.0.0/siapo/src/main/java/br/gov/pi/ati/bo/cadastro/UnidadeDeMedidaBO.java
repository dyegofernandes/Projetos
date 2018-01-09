package br.gov.pi.ati.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.dao.cadastro.UnidadeDeMedidaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.modelo.cadastro.UnidadeDeMedida;
import com.xpert.core.validation.UniqueFields;

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
        return new UniqueFields().add("codigo").add("nome");
    }

    @Override
    public void validate(UnidadeDeMedida unidadeDeMedida) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
