package br.gov.pi.salvemaria.mb.cadastro;

import br.gov.pi.salvemaria.bo.cadastro.BairroBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.salvemaria.bo.cadastro.UnidadeBO;
import br.gov.pi.salvemaria.modelo.cadastro.Bairro;
import br.gov.pi.salvemaria.modelo.cadastro.Cidade;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import com.xpert.persistence.query.JoinBuilder;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class UnidadeMB extends AbstractBaseBean<Unidade> implements Serializable {

    @EJB
    private UnidadeBO unidadeBO;

    @EJB
    private BairroBO bairroBO;

    private Cidade cidadeFiltro;

    private List<Bairro> bairros;

    @Override
    public UnidadeBO getBO() {
        return unidadeBO;
    }

    @Override
    public String getDataModelOrder() {
        return "unidade.nome";
    }

    @Override
    public void init() {
        if (getEntity().getId() != null) {
            Bairro bairro = unidadeBO.getDAO().getInitialized(getEntity().getEndereco().getBairro());
            cidadeFiltro = unidadeBO.getDAO().getInitialized(bairro.getCidade());
            bairroPelaCidade();
        }
    }

    public Cidade getCidadeFiltro() {
        return cidadeFiltro;
    }

    public void setCidadeFiltro(Cidade cidadeFiltro) {
        this.cidadeFiltro = cidadeFiltro;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void bairroPelaCidade() {
        if (cidadeFiltro != null) {
            bairros = bairroBO.bairrosPelaCidade(cidadeFiltro);
        } else {
            bairros = null;
        }
    }

    @Override
    public JoinBuilder getDataModelJoinBuilder() {
        return new JoinBuilder("unidade")
                .leftJoinFetch("unidade.circunscricao", "circunscricao")
                .leftJoinFetch("unidade.circunscricaoBairro", "circunscricaoBairro")
                .leftJoinFetch("unidade.endereco", "endereco").leftJoinFetch("endereco.bairro", "bairro")
                .leftJoinFetch("bairro.cidade", "cidade");
    }

}
