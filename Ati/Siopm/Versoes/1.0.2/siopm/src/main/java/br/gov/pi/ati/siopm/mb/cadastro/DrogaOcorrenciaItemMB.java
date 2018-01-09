package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.DrogaOcorrenciaItemBO;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrenciaItem;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DrogaOcorrenciaItemMB extends AbstractBaseBean<DrogaOcorrenciaItem> implements Serializable {

    @EJB
    private DrogaOcorrenciaItemBO drogaOcorrenciaItemBO;

    @Override
    public DrogaOcorrenciaItemBO getBO() {
        return drogaOcorrenciaItemBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new DrogaOcorrenciaItem());
    }
    
    
}
