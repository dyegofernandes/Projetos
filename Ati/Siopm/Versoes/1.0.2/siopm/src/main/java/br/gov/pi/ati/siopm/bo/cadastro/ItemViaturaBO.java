package br.gov.pi.ati.siopm.bo.cadastro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.siopm.dao.cadastro.ItemViaturaDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.siopm.modelo.cadastro.ItemViatura;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemViaturaBO extends AbstractBusinessObject<ItemViatura> {

    @EJB
    private ItemViaturaDAO itemViaturaDAO;
    
    @Override
    public ItemViaturaDAO getDAO() {
        return itemViaturaDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ItemViatura itemViatura) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
