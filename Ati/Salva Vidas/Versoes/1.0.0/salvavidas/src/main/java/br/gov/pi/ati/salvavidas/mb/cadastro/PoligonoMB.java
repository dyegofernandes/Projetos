package br.gov.pi.ati.salvavidas.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.salvavidas.bo.cadastro.PoligonoBO;
import br.gov.pi.ati.salvavidas.modelo.cadastro.Poligono;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PoligonoMB extends AbstractBaseBean<Poligono> implements Serializable {

    @EJB
    private PoligonoBO poligonoBO;

    @Override
    public PoligonoBO getBO() {
        return poligonoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
