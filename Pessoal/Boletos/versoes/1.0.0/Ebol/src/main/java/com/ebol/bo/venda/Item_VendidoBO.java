package com.ebol.bo.venda;

import com.xpert.core.crud.AbstractBusinessObject;
import com.ebol.dao.venda.Item_VendidoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.ebol.modelo.venda.Item_Vendido;

/**
 *
 * @author Juniel
 */
@Stateless
public class Item_VendidoBO extends AbstractBusinessObject<Item_Vendido> {

    @EJB
    private Item_VendidoDAO item_VendidoDAO;
    
    @Override
    public Item_VendidoDAO getDAO() {
        return item_VendidoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Item_Vendido item_Vendido) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
