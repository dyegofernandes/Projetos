package br.com.dizimo.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.cadastro.PaisBO;
import br.com.dizimo.modelo.cadastro.Pais;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PaisMB extends AbstractBaseBean<Pais> implements Serializable {

    @EJB
    private PaisBO paisBO;

    @Override
    public PaisBO getBO() {
        return paisBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
