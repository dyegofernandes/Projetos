package com.ebol.mb.venda;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.venda.Item_VendidoBO;
import com.ebol.modelo.venda.Item_Vendido;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class Item_VendidoMB extends AbstractBaseBean<Item_Vendido> implements Serializable {

    @EJB
    private Item_VendidoBO item_VendidoBO;

    @Override
    public Item_VendidoBO getBO() {
        return item_VendidoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
