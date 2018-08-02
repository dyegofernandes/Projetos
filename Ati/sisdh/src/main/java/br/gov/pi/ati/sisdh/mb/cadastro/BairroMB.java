package br.gov.pi.ati.sisdh.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.cadastro.BairroBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.Bairro;

/**
 *
 * @author ads01
 */
@ManagedBean
@ViewScoped
public class BairroMB extends AbstractBaseBean<Bairro> implements Serializable {

    @EJB
    private BairroBO bairroBO;

    @Override
    public BairroBO getBO() {
        return bairroBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
