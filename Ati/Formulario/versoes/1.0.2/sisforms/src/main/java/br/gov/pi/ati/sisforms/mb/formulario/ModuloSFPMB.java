package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.ModuloSFPBO;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFP;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ModuloSFPMB extends AbstractBaseBean<ModuloSFP> implements Serializable {

    @EJB
    private ModuloSFPBO moduloSFPBO;

    @Override
    public ModuloSFPBO getBO() {
        return moduloSFPBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
