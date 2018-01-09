package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.TerritorioPorCidadeBO;
import br.gov.pi.ati.siopm.modelo.cadastro.TerritorioPorCidade;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TerritorioPorCidadeMB extends AbstractBaseBean<TerritorioPorCidade> implements Serializable {

    @EJB
    private TerritorioPorCidadeBO territorioPorCidadeBO;

    @Override
    public TerritorioPorCidadeBO getBO() {
        return territorioPorCidadeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
