package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.ItemFormCriacaoEmailBO;
import br.gov.pi.ati.sisforms.modelo.formulario.ItemFormCriacaoEmail;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ItemFormCriacaoEmailMB extends AbstractBaseBean<ItemFormCriacaoEmail> implements Serializable {

    @EJB
    private ItemFormCriacaoEmailBO itemFormCriacaoEmailBO;

    @Override
    public ItemFormCriacaoEmailBO getBO() {
        return itemFormCriacaoEmailBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
