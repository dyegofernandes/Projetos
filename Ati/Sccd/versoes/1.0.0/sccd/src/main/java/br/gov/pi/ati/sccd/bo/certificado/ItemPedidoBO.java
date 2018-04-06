package br.gov.pi.ati.sccd.bo.certificado;

import com.xpert.core.crud.AbstractBusinessObject;
import br.gov.pi.ati.sccd.dao.certificado.ItemPedidoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemPedidoBO extends AbstractBusinessObject<ItemPedido> {

    @EJB
    private ItemPedidoDAO itemPedidoDAO;
    
    @Override
    public ItemPedidoDAO getDAO() {
        return itemPedidoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(ItemPedido itemPedido) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
