package br.com.aprove.bo.faturamento;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.aprove.dao.faturamento.ItemPedidoDAO;
import br.com.aprove.modelo.faturamento.Estoque;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.aprove.modelo.faturamento.ItemPedido;
import br.com.aprove.modelo.faturamento.Pedido;
import java.util.ArrayList;

/**
 *
 * @author juniel
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

    public List<ItemPedido> itensPorPedido(Pedido pedido) {
        List<ItemPedido> itens = new ArrayList<ItemPedido>();

        itens = getDAO().list("pedido", pedido);

        return itens;
    }

    public List<ItemPedido> itensPeloEstoque(Estoque estoque) {
        List<ItemPedido> itens = new ArrayList<ItemPedido>();

        itens = getDAO().list("estoque", estoque);

        return itens;
    }

}
