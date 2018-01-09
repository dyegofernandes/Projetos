package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.CalGuiaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.CalGuia;

/**
 *
 * @author Juniel
 */
@Stateless
public class CalGuiaBO extends AbstractBusinessObject<CalGuia> {

    @EJB
    private CalGuiaDAO calGuiaDAO;
    
    @Override
    public CalGuiaDAO getDAO() {
        return calGuiaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(CalGuia calGuia) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
