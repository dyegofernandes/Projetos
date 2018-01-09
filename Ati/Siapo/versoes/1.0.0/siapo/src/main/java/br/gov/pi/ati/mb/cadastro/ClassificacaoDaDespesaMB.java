package br.gov.pi.ati.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.ClassificacaoDaDespesaBO;
import br.gov.pi.ati.modelo.cadastro.ClassificacaoDaDespesa;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ClassificacaoDaDespesaMB extends AbstractBaseBean<ClassificacaoDaDespesa> implements Serializable {

    @EJB
    private ClassificacaoDaDespesaBO classificacaoDaDespesaBO;

    @Override
    public ClassificacaoDaDespesaBO getBO() {
        return classificacaoDaDespesaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
