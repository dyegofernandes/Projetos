package br.com.facilpagar.mb.dados;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.facilpagar.bo.dados.CidadeBO;
import br.com.facilpagar.modelo.dados.Cidade;
import java.util.List;

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

    public List<Cidade> autocomplete(String nome) {
        return getBO().listarCidadePeloNome(nome);
    }

}
