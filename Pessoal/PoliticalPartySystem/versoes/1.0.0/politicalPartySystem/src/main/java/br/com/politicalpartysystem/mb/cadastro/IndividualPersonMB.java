package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.IndividualPersonBO;
import br.com.politicalpartysystem.modelo.cadastro.IndividualPerson;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class IndividualPersonMB extends AbstractBaseBean<IndividualPerson> implements Serializable {

    @EJB
    private IndividualPersonBO individualPersonBO;

    @Override
    public IndividualPersonBO getBO() {
        return individualPersonBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
