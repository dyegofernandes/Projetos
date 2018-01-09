package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.StatusViaturaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.StatusViatura;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class StatusViaturaMB extends AbstractBaseBean<StatusViatura> implements Serializable {

    @EJB
    private StatusViaturaBO statusViaturaBO;

    @Override
    public StatusViaturaBO getBO() {
        return statusViaturaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
