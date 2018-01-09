package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.ItemViaturaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.ItemViatura;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ItemViaturaMB extends AbstractBaseBean<ItemViatura> implements Serializable {

    @EJB
    private ItemViaturaBO itemViaturaBO;

    @Override
    public ItemViaturaBO getBO() {
        return itemViaturaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
