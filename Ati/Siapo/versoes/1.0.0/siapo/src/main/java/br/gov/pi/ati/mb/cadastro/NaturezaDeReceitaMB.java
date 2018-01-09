package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.NaturezaDeReceitaBO;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeReceita;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class NaturezaDeReceitaMB extends AbstractBaseBean<NaturezaDeReceita> implements Serializable {

    @EJB
    private NaturezaDeReceitaBO naturezaDeReceitaBO;

    @Override
    public NaturezaDeReceitaBO getBO() {
        return naturezaDeReceitaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
