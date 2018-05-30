package br.gov.pi.ati.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.ProdutoBO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import br.gov.pi.ati.modelo.cadastro.Produto;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.util.SessaoUtils;
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
    
    private Usuario usuarioAtual;
    
    private List<UnidadeOrcamentaria> unidades;

    @Override
    public ProdutoBO getBO() {
        return produtoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        usuarioAtual = SessaoUtils.getUser();
        
        unidades = getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());
    }

    public List<UnidadeOrcamentaria> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadeOrcamentaria> unidades) {
        this.unidades = unidades;
    }
    
    

    public List<Produto> autocompletePeloNome(String nome) {
        return getBO().produtoPeloNome(nome);
    }

    public List<Produto> autocompletePeloNomeEacao(String nome) {
        return getBO().produtoPeloNomeComAcao(acao, nome);
    }

}
