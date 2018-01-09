package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.ModuloSFPOcorrenciaBO;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFPOcorrencia;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ModuloSFPOcorrenciaMB extends AbstractBaseBean<ModuloSFPOcorrencia> implements Serializable {

    @EJB
    private ModuloSFPOcorrenciaBO moduloSFPOcorrenciaBO;

    @Override
    public ModuloSFPOcorrenciaBO getBO() {
        return moduloSFPOcorrenciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
