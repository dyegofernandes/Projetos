package br.gov.pi.ati.siopm.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.MarcaDeArmaBO;
import br.gov.pi.ati.siopm.modelo.cadastro.MarcaDeArma;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MarcaDeArmaMB extends AbstractBaseBean<MarcaDeArma> implements Serializable {

    @EJB
    private MarcaDeArmaBO marcaDeArmaBO;

    @Override
    public MarcaDeArmaBO getBO() {
        return marcaDeArmaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new MarcaDeArma());
    }
}
