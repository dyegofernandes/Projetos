package br.gov.pi.ati.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.UnidadeOrcamentariaBO;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class UnidadeOrcamentariaMB extends AbstractBaseBean<UnidadeOrcamentaria> implements Serializable {

    @EJB
    private UnidadeOrcamentariaBO unidadeOrcamentariaBO;

    @Override
    public UnidadeOrcamentariaBO getBO() {
        return unidadeOrcamentariaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public List<UnidadeOrcamentaria> autocomplete(String nome) {
        return getBO().unidadePeloNome(nome);
    }

    public List<UnidadeOrcamentaria> autocompletePelaUnidadeAcesso(String nome) {
        return getBO().unidadePeloNomeEunidadeDeAcesso(nome);
    }
}
