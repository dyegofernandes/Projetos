package br.gov.pi.ati.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.ProdutoBO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.Produto;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ProdutoMB extends AbstractBaseBean<Produto> implements Serializable {

    @EJB
    private ProdutoBO produtoBO;

    private AcaoEstrategica acao;

    @Override
    public ProdutoBO getBO() {
        return produtoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    public List<Produto> autocompletePeloNome(String nome) {
        return getBO().produtoPeloNome(nome);
    }

    public List<Produto> autocompletePeloNomeEacao(String nome) {
        return getBO().produtoPeloNomeComAcao(acao, nome);
    }

}
