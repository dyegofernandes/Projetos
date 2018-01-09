package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.AddressBO;
import br.com.politicalpartysystem.modelo.cadastro.Address;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AddressMB extends AbstractBaseBean<Address> implements Serializable {

    @EJB
    private AddressBO addressBO;

    @Override
    public AddressBO getBO() {
        return addressBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
