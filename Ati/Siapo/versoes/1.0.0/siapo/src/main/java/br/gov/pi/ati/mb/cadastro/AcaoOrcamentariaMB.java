package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.AcaoOrcamentariaBO;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AcaoOrcamentariaMB extends AbstractBaseBean<AcaoOrcamentaria> implements Serializable {

    @EJB
    private AcaoOrcamentariaBO acaoOrcamentariaBO;

    @Override
    public AcaoOrcamentariaBO getBO() {
        return acaoOrcamentariaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
