package br.gov.pi.ati.sisdh.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.sisdh.bo.cadastro.TerritorioCidadeBO;
import br.gov.pi.ati.sisdh.modelo.cadastro.TerritorioCidade;

/**
 *
 * @author ads01
 */
@ManagedBean
@ViewScoped
public class TerritorioCidadeMB extends AbstractBaseBean<TerritorioCidade> implements Serializable {

    @EJB
    private TerritorioCidadeBO territorioCidadeBO;

    @Override
    public TerritorioCidadeBO getBO() {
        return territorioCidadeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
