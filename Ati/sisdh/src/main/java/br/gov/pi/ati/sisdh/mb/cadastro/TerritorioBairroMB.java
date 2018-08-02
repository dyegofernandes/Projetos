package br.gov.pi.ati.sisdh.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.cadastro.TerritorioBairroBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.TerritorioBairro;

/**
 *
 * @author ads01
 */
@ManagedBean
@ViewScoped
public class TerritorioBairroMB extends AbstractBaseBean<TerritorioBairro> implements Serializable {

    @EJB
    private TerritorioBairroBO territorioBairroBO;

    @Override
    public TerritorioBairroBO getBO() {
        return territorioBairroBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
