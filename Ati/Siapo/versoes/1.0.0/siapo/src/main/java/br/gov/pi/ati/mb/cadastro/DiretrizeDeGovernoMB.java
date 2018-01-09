package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.DiretrizeDeGovernoBO;
import br.gov.pi.ati.modelo.cadastro.DiretrizeDeGoverno;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DiretrizeDeGovernoMB extends AbstractBaseBean<DiretrizeDeGoverno> implements Serializable {

    @EJB
    private DiretrizeDeGovernoBO diretrizeDeGovernoBO;

    @Override
    public DiretrizeDeGovernoBO getBO() {
        return diretrizeDeGovernoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
