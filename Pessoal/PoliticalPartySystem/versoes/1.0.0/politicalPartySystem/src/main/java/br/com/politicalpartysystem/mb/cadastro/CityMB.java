package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.CityBO;
import br.com.politicalpartysystem.modelo.cadastro.City;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CityMB extends AbstractBaseBean<City> implements Serializable {

    @EJB
    private CityBO cityBO;

    @Override
    public CityBO getBO() {
        return cityBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
