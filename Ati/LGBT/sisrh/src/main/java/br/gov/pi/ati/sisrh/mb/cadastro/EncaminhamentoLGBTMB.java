package br.gov.pi.ati.sisrh.mb.cadastro;


import br.gov.pi.ati.sisrh.bo.cadastro.EncaminhamentoLGBTBO;
import br.gov.pi.ati.sisrh.modelo.cadastro.EncaminhamentoLGBT;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
