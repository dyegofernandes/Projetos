package br.gov.pi.salvemaria.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.cadastro.UnidadeBO;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class UnidadeMB extends AbstractBaseBean<Unidade> implements Serializable {

    @EJB
    private UnidadeBO unidadeBO;

    @Override
    public UnidadeBO getBO() {
        return unidadeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
