package br.com.dizimo.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.cadastro.SedeBO;
import br.com.dizimo.modelo.cadastro.Sede;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class SedeMB extends AbstractBaseBean<Sede> implements Serializable {

    @EJB
    private SedeBO sedeBO;

    @Override
    public SedeBO getBO() {
        return sedeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
