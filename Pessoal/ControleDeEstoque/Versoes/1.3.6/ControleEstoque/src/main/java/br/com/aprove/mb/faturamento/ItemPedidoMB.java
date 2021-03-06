package br.com.aprove.mb.faturamento;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.faturamento.ItemPedidoBO;
import br.com.aprove.modelo.faturamento.ItemPedido;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class ItemPedidoMB extends AbstractBaseBean<ItemPedido> implements Serializable {

    @EJB
    private ItemPedidoBO itemPedidoBO;

    @Override
    public ItemPedidoBO getBO() {
        return itemPedidoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
