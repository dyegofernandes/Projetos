package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.DrogaOcorrenciaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrencia;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DrogaOcorrenciaMB extends AbstractBaseBean<DrogaOcorrencia> implements Serializable {
    
    @EJB
    private DrogaOcorrenciaBO drogaOcorrenciaBO;
    
    @Override
    public DrogaOcorrenciaBO getBO() {
        return drogaOcorrenciaBO;
    }
    
    @Override
    public String getDataModelOrder() {
        return "nome";
    }
    
    @Override
    public void postSave() {
        setEntity(new DrogaOcorrencia());
    }
    
}
