package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.ItemDaRequisicaoDeMaterialBO;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemDaRequisicaoDeMaterial;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ItemDaRequisicaoDeMaterialMB extends AbstractBaseBean<ItemDaRequisicaoDeMaterial> implements Serializable {

    @EJB
    private ItemDaRequisicaoDeMaterialBO itemDaRequisicaoDeMaterialBO;

    @Override
    public ItemDaRequisicaoDeMaterialBO getBO() {
        return itemDaRequisicaoDeMaterialBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
