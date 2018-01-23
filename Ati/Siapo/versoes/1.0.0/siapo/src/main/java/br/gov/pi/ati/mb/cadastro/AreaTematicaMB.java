package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.AreaTematicaBO;
import br.gov.pi.ati.modelo.cadastro.AreaTematica;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AreaTematicaMB extends AbstractBaseBean<AreaTematica> implements Serializable {

    @EJB
    private AreaTematicaBO areaTematicaBO;

    @Override
    public AreaTematicaBO getBO() {
        return areaTematicaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
