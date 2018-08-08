package br.com.dizimo.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.dizimo.dao.financeiro.DizimoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.dizimo.modelo.financeiro.Dizimo;

/**
 *
 * @author Juniel
 */
@Stateless
public class DizimoBO extends AbstractBusinessObject<Dizimo> {

    @EJB
    private DizimoDAO dizimoDAO;
    
    @Override
    public DizimoDAO getDAO() {
        return dizimoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Dizimo dizimo) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
