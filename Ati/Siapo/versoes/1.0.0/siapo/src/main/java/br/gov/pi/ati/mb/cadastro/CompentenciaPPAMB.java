package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.CompentenciaPPABO;
import br.gov.pi.ati.modelo.cadastro.CompentenciaPPA;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CompentenciaPPAMB extends AbstractBaseBean<CompentenciaPPA> implements Serializable {

    @EJB
    private CompentenciaPPABO compentenciaPPABO;

    @Override
    public CompentenciaPPABO getBO() {
        return compentenciaPPABO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
