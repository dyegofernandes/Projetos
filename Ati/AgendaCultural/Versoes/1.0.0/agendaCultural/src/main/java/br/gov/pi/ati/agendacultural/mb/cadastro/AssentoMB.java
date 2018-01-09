package br.gov.pi.ati.agendacultural.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.agendacultural.bo.cadastro.AssentoBO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Assento;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AssentoMB extends AbstractBaseBean<Assento> implements Serializable {

    @EJB
    private AssentoBO assentoBO;

    @Override
    public AssentoBO getBO() {
        return assentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
