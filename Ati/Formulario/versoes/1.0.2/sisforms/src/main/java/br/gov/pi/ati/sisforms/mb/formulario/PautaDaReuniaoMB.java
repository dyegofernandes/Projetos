package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.PautaDaReuniaoBO;
import br.gov.pi.ati.sisforms.modelo.formulario.PautaDaReuniao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PautaDaReuniaoMB extends AbstractBaseBean<PautaDaReuniao> implements Serializable {

    @EJB
    private PautaDaReuniaoBO pautaDaReuniaoBO;

    @Override
    public PautaDaReuniaoBO getBO() {
        return pautaDaReuniaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
