package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.UnidadeGestoraBO;
import br.gov.pi.ati.modelo.cadastro.UnidadeGestora;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class UnidadeGestoraMB extends AbstractBaseBean<UnidadeGestora> implements Serializable {

    @EJB
    private UnidadeGestoraBO unidadeGestoraBO;

    @Override
    public UnidadeGestoraBO getBO() {
        return unidadeGestoraBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
