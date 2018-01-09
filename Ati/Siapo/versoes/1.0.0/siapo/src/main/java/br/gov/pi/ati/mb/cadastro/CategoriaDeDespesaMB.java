package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.CategoriaDeDespesaBO;
import br.gov.pi.ati.modelo.cadastro.CategoriaDeDespesa;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CategoriaDeDespesaMB extends AbstractBaseBean<CategoriaDeDespesa> implements Serializable {

    @EJB
    private CategoriaDeDespesaBO categoriaDeDespesaBO;

    @Override
    public CategoriaDeDespesaBO getBO() {
        return categoriaDeDespesaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
