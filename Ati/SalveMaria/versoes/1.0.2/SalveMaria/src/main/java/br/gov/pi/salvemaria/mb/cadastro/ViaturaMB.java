package br.gov.pi.salvemaria.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.cadastro.ViaturaBO;
import br.gov.pi.salvemaria.modelo.cadastro.Viatura;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ViaturaMB extends AbstractBaseBean<Viatura> implements Serializable {

    @EJB
    private ViaturaBO viaturaBO;

    @Override
    public ViaturaBO getBO() {
        return viaturaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
