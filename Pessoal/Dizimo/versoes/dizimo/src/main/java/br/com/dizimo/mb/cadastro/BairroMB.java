package br.com.dizimo.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.cadastro.BairroBO;
import br.com.dizimo.modelo.cadastro.Bairro;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BairroMB extends AbstractBaseBean<Bairro> implements Serializable {

    @EJB
    private BairroBO bairroBO;

    @Override
    public BairroBO getBO() {
        return bairroBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
