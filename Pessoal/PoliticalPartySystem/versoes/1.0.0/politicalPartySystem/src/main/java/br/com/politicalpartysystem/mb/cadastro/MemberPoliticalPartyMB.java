package br.com.politicalpartysystem.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.politicalpartysystem.bo.cadastro.MemberPoliticalPartyBO;
import br.com.politicalpartysystem.modelo.cadastro.MemberPoliticalParty;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MemberPoliticalPartyMB extends AbstractBaseBean<MemberPoliticalParty> implements Serializable {

    @EJB
    private MemberPoliticalPartyBO memberPoliticalPartyBO;

    @Override
    public MemberPoliticalPartyBO getBO() {
        return memberPoliticalPartyBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
