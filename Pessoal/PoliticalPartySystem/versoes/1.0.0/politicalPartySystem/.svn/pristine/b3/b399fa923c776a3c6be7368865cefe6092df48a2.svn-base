package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.PoliticalPartyBO;
import br.com.politicalpartysystem.modelo.cadastro.PoliticalParty;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PoliticalPartyMB extends AbstractBaseBean<PoliticalParty> implements Serializable {

    @EJB
    private PoliticalPartyBO politicalPartyBO;

    @Override
    public PoliticalPartyBO getBO() {
        return politicalPartyBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
