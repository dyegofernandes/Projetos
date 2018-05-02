package br.gov.pi.ati.sccd.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sccd.bo.cadastro.FeriadoBO;
import br.gov.pi.ati.sccd.modelo.cadastro.Feriado;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FeriadoMB extends AbstractBaseBean<Feriado> implements Serializable {

    @EJB
    private FeriadoBO feriadoBO;

    @Override
    public FeriadoBO getBO() {
        return feriadoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
