package br.gov.pi.ati.mb.orcamento;

import br.gov.pi.ati.bo.cadastro.ProdutoBO;
import br.gov.pi.ati.bo.orcamento.MetaAcaoEstrategicaBO;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.MetaProdutoBO;
import br.gov.pi.ati.modelo.cadastro.Produto;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;
import br.gov.pi.ati.modelo.orcamento.MetaProduto;
import br.gov.pi.ati.modelo.orcamento.TerritorioPPA;
import br.gov.pi.ati.util.SessaoUtils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MetaProdutoMB extends AbstractBaseBean<MetaProduto> implements Serializable {

    @EJB
    private MetaProdutoBO metaProdutoBO;

    @EJB
    private MetaAcaoEstrategicaBO metaAcaoBO;

    @EJB
    private ProdutoBO produtoBO;

    private Filtros filtros;

    private List<TerritorioPPA> territorios;

    private TerritorioPPA territorioAdd;

    private List<MetaProduto> produdos;

    private Usuario usuarioAtual;

    private List<UnidadeOrcamentaria> unidades;

    @Override
    public MetaProdutoBO getBO() {
        return metaProdutoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void save() {
        super.save();
    }

    @Override
    public void init() {

        usuarioAtual = SessaoUtils.getUser();

        territorios = new ArrayList<TerritorioPPA>();
        territorioAdd = new TerritorioPPA();

        filtros = new Filtros();
        unidades = getDAO().getInitialized(usuarioAtual.getUnidadesDeAcesso());
        filtros.setUnidadesOrcamentaria(unidades);

        if (getEntity().getId() != null) {
            territorios = getDAO().getInitialized(getEntity().getTerritorios());
        }
    }

    public void addTerritorio() {
        if (territorioAdd.getTerritorio() != null) {
            if (territorioAdd.getValor() != null) {
                if (territorioJahAdicionado(territorioAdd)) {
                    FacesMessageUtils.error("Território já adicionado!");
                } else {
                    territorios.add(territorioAdd);
                    territorioAdd = new TerritorioPPA();
                }
            } else {
                FacesMessageUtils.error("Valor da meta do Território é obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Território é obrigatório!");
        }
    }

    public void removerTerritorio(TerritorioPPA territorio) {
        territorios.remove(territorio);
    }

    public boolean territorioJahAdicionado(TerritorioPPA territorio) {
        for (TerritorioPPA territorioTemp : territorios) {
            if (territorioTemp.getTerritorio().equals(territorio.getTerritorio())) {
                return true;
            }
        }
        return false;
    }

    public Filtros getFiltros() {
        return filtros;
    }

    public void setFiltros(Filtros filtros) {
        this.filtros = filtros;
    }

    public List<TerritorioPPA> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<TerritorioPPA> territorios) {
        this.territorios = territorios;
    }

    public TerritorioPPA getTerritorioAdd() {
        return territorioAdd;
    }

    public void setTerritorioAdd(TerritorioPPA territorioAdd) {
        this.territorioAdd = territorioAdd;
    }

    public List<MetaProduto> getProdudos() {
        return produdos;
    }

    public void setProdudos(List<MetaProduto> produdos) {
        this.produdos = produdos;
    }

    public List<UnidadeOrcamentaria> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<UnidadeOrcamentaria> unidades) {
        this.unidades = unidades;
    }

    public List<MetaAcaoEstrategica> autocompleteMetaAcao(String nome) {
        return metaAcaoBO.listarPeloNome(usuarioAtual.getUnidadesDeAcesso(), nome);
    }

    public List<Produto> autocompleteProduto(String nome) {
        return produtoBO.produtoPeloNome(usuarioAtual.getUnidadesDeAcesso(), nome);
    }

    public void buscar() {
        produdos = getBO().listar(filtros);
    }
}
