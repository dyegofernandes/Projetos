package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.LegalPersonBO;
import br.com.politicalpartysystem.modelo.cadastro.LegalPerson;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class LegalPersonMB extends AbstractBaseBean<LegalPerson> implements Serializable {

    @EJB
    private LegalPersonBO legalPersonBO;

    @Override
    public LegalPersonBO getBO() {
        return legalPersonBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
