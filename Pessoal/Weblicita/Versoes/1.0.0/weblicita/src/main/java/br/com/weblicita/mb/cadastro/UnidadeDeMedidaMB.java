package br.com.weblicita.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.weblicita.bo.cadastro.UnidadeDeMedidaBO;
import br.com.weblicita.modelo.cadastro.UnidadeDeMedida;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class UnidadeDeMedidaMB extends AbstractBaseBean<UnidadeDeMedida> implements Serializable {

    @EJB
    private UnidadeDeMedidaBO unidadeDeMedidaBO;

    @Override
    public UnidadeDeMedidaBO getBO() {
        return unidadeDeMedidaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
