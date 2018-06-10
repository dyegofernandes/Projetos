package br.com.facilpagar.mb.dados;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.facilpagar.bo.dados.CategoriaBO;
import br.com.facilpagar.modelo.dados.Categoria;

/**
 *
 * @author jj
 */
@ManagedBean
@ViewScoped
public class CategoriaMB extends AbstractBaseBean<Categoria> implements Serializable {

    @EJB
    private CategoriaBO categoriaBO;

    @Override
    public CategoriaBO getBO() {
        return categoriaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
