package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.TipoFloatDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TipoFloat;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoFloatBO extends AbstractBusinessObject<TipoFloat> {

    @EJB
    private TipoFloatDAO tipoFloatDAO;
    
    @Override
    public TipoFloatDAO getDAO() {
        return tipoFloatDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(TipoFloat tipoFloat) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
