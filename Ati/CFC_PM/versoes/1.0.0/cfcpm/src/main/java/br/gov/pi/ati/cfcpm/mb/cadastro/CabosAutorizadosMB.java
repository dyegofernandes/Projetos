package br.gov.pi.ati.cfcpm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.cfcpm.bo.cadastro.CabosAutorizadosBO;
import br.gov.pi.ati.cfcpm.modelo.cadastro.CabosAutorizados;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CabosAutorizadosMB extends AbstractBaseBean<CabosAutorizados> implements Serializable {

    @EJB
    private CabosAutorizadosBO cabosAutorizadosBO;

    @Override
    public CabosAutorizadosBO getBO() {
        return cabosAutorizadosBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
