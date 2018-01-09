package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.LocalIntermediarioBO;
import br.gov.pi.ati.siopm.modelo.cadastro.LocalIntermediario;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LocalIntermediarioMB extends AbstractBaseBean<LocalIntermediario> implements Serializable {

    @EJB
    private LocalIntermediarioBO localIntermediarioBO;

    @Override
    public LocalIntermediarioBO getBO() {
        return localIntermediarioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
