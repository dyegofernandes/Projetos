package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.PhoneBO;
import br.com.politicalpartysystem.modelo.cadastro.Phone;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PhoneMB extends AbstractBaseBean<Phone> implements Serializable {

    @EJB
    private PhoneBO phoneBO;

    @Override
    public PhoneBO getBO() {
        return phoneBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
