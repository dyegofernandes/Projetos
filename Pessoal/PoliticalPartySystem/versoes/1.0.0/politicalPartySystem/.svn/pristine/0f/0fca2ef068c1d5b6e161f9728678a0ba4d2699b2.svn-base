package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.UserPoliticalPartyBO;
import br.com.politicalpartysystem.modelo.cadastro.UserPoliticalParty;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class UserPoliticalPartyMB extends AbstractBaseBean<UserPoliticalParty> implements Serializable {

    @EJB
    private UserPoliticalPartyBO userPoliticalPartyBO;

    @Override
    public UserPoliticalPartyBO getBO() {
        return userPoliticalPartyBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
