package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.SolicitanteBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Solicitante;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class SolicitanteMB extends AbstractBaseBean<Solicitante> implements Serializable {

    @EJB
    private SolicitanteBO solicitanteBO;

    @Override
    public SolicitanteBO getBO() {
        return solicitanteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
