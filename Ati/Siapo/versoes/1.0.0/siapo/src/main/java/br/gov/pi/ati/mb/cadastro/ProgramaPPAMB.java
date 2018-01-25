package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.ProgramaPPABO;
import br.gov.pi.ati.modelo.cadastro.ProgramaPPA;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ProgramaPPAMB extends AbstractBaseBean<ProgramaPPA> implements Serializable {

    @EJB
    private ProgramaPPABO programaPPABO;

    @Override
    public ProgramaPPABO getBO() {
        return programaPPABO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
