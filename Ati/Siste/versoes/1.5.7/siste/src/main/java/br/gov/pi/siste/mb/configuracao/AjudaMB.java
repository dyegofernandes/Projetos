package br.gov.pi.siste.mb.configuracao;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.configuracao.AjudaBO;
import br.gov.pi.siste.modelo.configuracao.Ajuda;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AjudaMB extends AbstractBaseBean<Ajuda> implements Serializable {

    @EJB
    private AjudaBO ajudaBO;

    @Override
    public AjudaBO getBO() {
        return ajudaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "titulo";
    }
}
