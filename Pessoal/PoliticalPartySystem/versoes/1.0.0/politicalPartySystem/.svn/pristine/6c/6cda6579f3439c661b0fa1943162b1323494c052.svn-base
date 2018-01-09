package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.CountryBO;
import br.com.politicalpartysystem.modelo.cadastro.Country;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CountryMB extends AbstractBaseBean<Country> implements Serializable {

    @EJB
    private CountryBO countryBO;

    @Override
    public CountryBO getBO() {
        return countryBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
