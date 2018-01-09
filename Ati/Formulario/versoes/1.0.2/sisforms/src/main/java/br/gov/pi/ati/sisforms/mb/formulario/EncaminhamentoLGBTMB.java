package br.gov.pi.ati.sisforms.mb.formulario;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.formulario.EncaminhamentoLGBTBO;
import br.gov.pi.ati.sisforms.modelo.formulario.EncaminhamentoLGBT;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class EncaminhamentoLGBTMB extends AbstractBaseBean<EncaminhamentoLGBT> implements Serializable {

    @EJB
    private EncaminhamentoLGBTBO encaminhamentoLGBTBO;

    @Override
    public EncaminhamentoLGBTBO getBO() {
        return encaminhamentoLGBTBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
