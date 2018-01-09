package br.gov.pi.salvemaria.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.cadastro.CidadeBO;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CidadeMB extends AbstractBaseBean<Cidade> implements Serializable {

    @EJB
    private CidadeBO cidadeBO;

    @Override
    public CidadeBO getBO() {
        return cidadeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
