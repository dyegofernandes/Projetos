package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.ArmaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Arma;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ArmaMB extends AbstractBaseBean<Arma> implements Serializable {

    @EJB
    private ArmaBO armaBO;

    @Override
    public ArmaBO getBO() {
        return armaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new Arma());
    }
}
