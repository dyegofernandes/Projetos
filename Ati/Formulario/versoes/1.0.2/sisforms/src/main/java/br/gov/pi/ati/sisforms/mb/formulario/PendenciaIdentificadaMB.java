package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.PendenciaIdentificadaBO;
import br.gov.pi.ati.sisforms.modelo.formulario.PendenciaIdentificada;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PendenciaIdentificadaMB extends AbstractBaseBean<PendenciaIdentificada> implements Serializable {

    @EJB
    private PendenciaIdentificadaBO pendenciaIdentificadaBO;

    @Override
    public PendenciaIdentificadaBO getBO() {
        return pendenciaIdentificadaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
