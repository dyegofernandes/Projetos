package br.gov.pi.ati.sisforms.mb.servicos;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.servicos.ReservaLocalBO;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ReservaLocalMB extends AbstractBaseBean<ReservaLocal> implements Serializable {

    @EJB
    private ReservaLocalBO reservaLocalBO;

    @Override
    public ReservaLocalBO getBO() {
        return reservaLocalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
