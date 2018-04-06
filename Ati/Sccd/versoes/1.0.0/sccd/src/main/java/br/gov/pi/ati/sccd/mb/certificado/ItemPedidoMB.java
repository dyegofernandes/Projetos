package br.gov.pi.ati.sccd.mb.certificado;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.certificado.ItemPedidoBO;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;

/**
 *
 * @author Juniel
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
