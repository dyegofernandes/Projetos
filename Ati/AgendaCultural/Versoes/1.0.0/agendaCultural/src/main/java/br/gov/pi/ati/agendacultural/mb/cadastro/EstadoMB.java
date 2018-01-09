package br.gov.pi.ati.agendacultural.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.agendacultural.bo.cadastro.EstadoBO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Estado;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class EstadoMB extends AbstractBaseBean<Estado> implements Serializable {

    @EJB
    private EstadoBO estadoBO;

    @Override
    public EstadoBO getBO() {
        return estadoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
