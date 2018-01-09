package br.gov.pi.ati.sisforms.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisforms.bo.cadastro.OrgaoCertificadoBO;
import br.gov.pi.ati.sisforms.modelo.cadastro.OrgaoCertificado;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OrgaoCertificadoMB extends AbstractBaseBean<OrgaoCertificado> implements Serializable {

    @EJB
    private OrgaoCertificadoBO orgaoCertificadoBO;

    @Override
    public OrgaoCertificadoBO getBO() {
        return orgaoCertificadoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
