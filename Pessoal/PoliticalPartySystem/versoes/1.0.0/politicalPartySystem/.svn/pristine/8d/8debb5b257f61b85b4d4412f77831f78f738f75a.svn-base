package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.PersonBO;
import br.com.politicalpartysystem.modelo.cadastro.Person;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PersonMB extends AbstractBaseBean<Person> implements Serializable {

    @EJB
    private PersonBO personBO;

    @Override
    public PersonBO getBO() {
        return personBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
