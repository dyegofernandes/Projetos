package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.PerfilSFPBO;
import br.gov.pi.ati.sisforms.modelo.formulario.PerfilSFP;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PerfilSFPMB extends AbstractBaseBean<PerfilSFP> implements Serializable {

    @EJB
    private PerfilSFPBO perfilSFPBO;

    @Override
    public PerfilSFPBO getBO() {
        return perfilSFPBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
