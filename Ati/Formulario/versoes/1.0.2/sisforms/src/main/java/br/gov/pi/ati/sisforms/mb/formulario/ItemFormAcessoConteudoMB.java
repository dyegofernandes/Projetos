package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.ItemFormAcessoConteudoBO;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormAcessoConteudo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ItemFormAcessoConteudoMB extends AbstractBaseBean<ItemFormAcessoConteudo> implements Serializable {

    @EJB
    private ItemFormAcessoConteudoBO itemFormAcessoConteudoBO;

    @Override
    public ItemFormAcessoConteudoBO getBO() {
        return itemFormAcessoConteudoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
