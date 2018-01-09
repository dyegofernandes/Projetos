package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.NeighborhoodBO;
import br.com.politicalpartysystem.modelo.cadastro.Neighborhood;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class NeighborhoodMB extends AbstractBaseBean<Neighborhood> implements Serializable {

    @EJB
    private NeighborhoodBO neighborhoodBO;

    @Override
    public NeighborhoodBO getBO() {
        return neighborhoodBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
