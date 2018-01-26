package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.AcaoEstrategicaBO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AcaoEstrategicaMB extends AbstractBaseBean<AcaoEstrategica> implements Serializable {

    @EJB
    private AcaoEstrategicaBO acaoEstrategicaBO;

    @Override
    public AcaoEstrategicaBO getBO() {
        return acaoEstrategicaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    
}
