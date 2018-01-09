package br.gov.pi.ati.agendacultural.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.agendacultural.bo.cadastro.TipoLocalBO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.TipoLocal;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TipoLocalMB extends AbstractBaseBean<TipoLocal> implements Serializable {

    @EJB
    private TipoLocalBO tipoLocalBO;

    @Override
    public TipoLocalBO getBO() {
        return tipoLocalBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
