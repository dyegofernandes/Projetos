package br.gov.pi.ati.adapi.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.adapi.bo.cadastro.SinalClinicoBO;
import br.gov.pi.ati.adapi.modelo.cadastro.SinalClinico;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class SinalClinicoMB extends AbstractBaseBean<SinalClinico> implements Serializable {

    @EJB
    private SinalClinicoBO sinalClinicoBO;

    @Override
    public SinalClinicoBO getBO() {
        return sinalClinicoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
