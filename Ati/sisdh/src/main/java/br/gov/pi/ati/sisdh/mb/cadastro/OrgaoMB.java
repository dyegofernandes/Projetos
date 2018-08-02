package br.gov.pi.ati.sisdh.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.cadastro.OrgaoBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.Orgao;

/**
 *
 * @author ads01
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
        return "id";
    }
}
