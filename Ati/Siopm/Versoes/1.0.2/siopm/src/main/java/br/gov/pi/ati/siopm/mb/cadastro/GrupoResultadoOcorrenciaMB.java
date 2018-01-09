package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.GrupoResultadoOcorrenciaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.GrupoResultadoOcorrencia;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class GrupoResultadoOcorrenciaMB extends AbstractBaseBean<GrupoResultadoOcorrencia> implements Serializable {

    @EJB
    private GrupoResultadoOcorrenciaBO grupoResultadoOcorrenciaBO;

    @Override
    public GrupoResultadoOcorrenciaBO getBO() {
        return grupoResultadoOcorrenciaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new GrupoResultadoOcorrencia());
    }
    
    
}
