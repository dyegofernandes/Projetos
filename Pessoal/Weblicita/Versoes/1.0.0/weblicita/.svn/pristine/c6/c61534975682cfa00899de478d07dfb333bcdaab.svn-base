package br.com.weblicita.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.weblicita.modelo.cadastro.Item;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemBO extends AbstractBusinessObject<Item> {

    @EJB
    private ItemDAO itemDAO;
    
    @Override
    public ItemDAO getDAO() {
        return itemDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Item item) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
