package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.OrgaoRecebedorBO;
import br.gov.pi.ati.siopm.modelo.cadastro.OrgaoRecebedor;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OrgaoRecebedorMB extends AbstractBaseBean<OrgaoRecebedor> implements Serializable {

    @EJB
    private OrgaoRecebedorBO orgaoRecebedorBO;

    @Override
    public OrgaoRecebedorBO getBO() {
        return orgaoRecebedorBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
