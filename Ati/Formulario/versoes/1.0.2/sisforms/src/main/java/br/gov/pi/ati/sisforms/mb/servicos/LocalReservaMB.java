package br.gov.pi.ati.sisforms.mb.servicos;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.servicos.LocalReservaBO;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LocalReservaMB extends AbstractBaseBean<LocalReserva> implements Serializable {

    @EJB
    private LocalReservaBO localReservaBO;

    @Override
    public LocalReservaBO getBO() {
        return localReservaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
