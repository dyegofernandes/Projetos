package br.gov.pi.siste.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.cadastro.OrgaoBO;
import br.gov.pi.siste.modelo.cadastro.Orgao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OrgaoMB extends AbstractBaseBean<Orgao> implements Serializable {

    @EJB
    private OrgaoBO orgaoBO;

    @Override
    public OrgaoBO getBO() {
        return orgaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "nome";
    }
    
    @Override
    public void postSave() {
        setEntity(new Orgao());
    }
}
