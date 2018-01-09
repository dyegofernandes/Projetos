package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.TerritorioBO;
import br.gov.pi.ati.modelo.cadastro.Territorio;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TerritorioMB extends AbstractBaseBean<Territorio> implements Serializable {

    @EJB
    private TerritorioBO territorioBO;

    @Override
    public TerritorioBO getBO() {
        return territorioBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
