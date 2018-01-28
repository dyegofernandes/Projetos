package br.com.weblicita.dao.cadastro.impl;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.ItemBO;
import br.com.weblicita.modelo.cadastro.Item;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ItemMB extends AbstractBaseBean<Item> implements Serializable {

    @EJB
    private ItemBO itemBO;

    @Override
    public ItemBO getBO() {
        return itemBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
