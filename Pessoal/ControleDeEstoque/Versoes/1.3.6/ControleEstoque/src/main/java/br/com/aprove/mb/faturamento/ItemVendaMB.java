package br.com.aprove.mb.faturamento;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.aprove.bo.faturamento.ItemVendaBO;
import br.com.aprove.modelo.faturamento.ItemVenda;

/**
 *
 * @author juniel
 */
@ManagedBean
@ViewScoped
public class ItemVendaMB extends AbstractBaseBean<ItemVenda> implements Serializable {

    @EJB
    private ItemVendaBO itemVendaBO;

    @Override
    public ItemVendaBO getBO() {
        return itemVendaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
