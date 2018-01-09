package br.com.jsoft.centralfinanceira.bo.central;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.jsoft.centralfinanceira.dao.central.CalGuiaItemDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.CalGuiaItem;

/**
 *
 * @author Juniel
 */
@Stateless
public class CalGuiaItemBO extends AbstractBusinessObject<CalGuiaItem> {

    @EJB
    private CalGuiaItemDAO calGuiaItemDAO;
    
    @Override
    public CalGuiaItemDAO getDAO() {
        return calGuiaItemDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(CalGuiaItem calGuiaItem) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
