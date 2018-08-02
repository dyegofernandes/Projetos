package br.gov.pi.ati.sisdh.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.cadastro.UnidadeBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.Unidade;

/**
 *
 * @author ads01
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
