package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.GrupoDeFonteBO;
import br.gov.pi.ati.modelo.cadastro.GrupoDeFonte;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class GrupoDeFonteMB extends AbstractBaseBean<GrupoDeFonte> implements Serializable {

    @EJB
    private GrupoDeFonteBO grupoDeFonteBO;

    @Override
    public GrupoDeFonteBO getBO() {
        return grupoDeFonteBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
