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
import br.gov.pi.ati.modelo.cadastro.Territorio;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.controleacesso.Usuario;
import br.gov.pi.ati.modelo.orcamento.Ldo;
import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;
import br.gov.pi.ati.modelo.orcamento.MetaProduto;
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

    private List<Ldo> ldos;

    private Ldo ldoAdd;

    private List<Territorio> territorios;

    private Territorio territorioAdd;

    private List<MetaProduto> produdos;

    private Usuario usuarioAtual;

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
        getEntity().setLdos(ldos);
        super.save();
    }

    @Override
    public void init() {

        usuarioAtual = SessaoUtils.getUser();
        ldos = new ArrayList<Ldo>();
        ldoAdd = new Ldo();

        territorios = new ArrayList<Territorio>();
        territorioAdd = new Territorio();

        filtros = new Filtros();
        filtros.setUnidadesOrcamentaria(getDAO().getInitialized(SessaoUtils.getUser().getUnidadesDeAcesso()));

        if (getEntity().getId() != null) {
            ldos = getDAO().getInitialized(getEntity().getLdos());
        }
    }

    public Filtros getFiltros() {
        return filtros;
    }

    public void setFiltros(Filtros filtros) {
        this.filtros = filtros;
    }

    public List<Ldo> getLdos() {
        return ldos;
    }

    public void setLdos(List<Ldo> ldos) {
        this.ldos = ldos;
    }

    public Ldo getLdoAdd() {
        return ldoAdd;
    }

    public void setLdoAdd(Ldo ldoAdd) {
        this.ldoAdd = ldoAdd;
    }

    public List<Territorio> getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List<Territorio> territorios) {
        this.territorios = territorios;
    }

    public Territorio getTerritorioAdd() {
        return territorioAdd;
    }

    public void setTerritorioAdd(Territorio territorioAdd) {
        this.territorioAdd = territorioAdd;
    }

    public List<MetaProduto> getProdudos() {
        return produdos;
    }

    public void setProdudos(List<MetaProduto> produdos) {
        this.produdos = produdos;
    }

    public void addLDO() {
        if (ldoAdd.getAno() != null) {
            if (ldoAdd.getMeta() != null) {
                if (ldoJahAdicionado(ldoAdd)) {
                    FacesMessageUtils.error("O valor referente para o ano informado já foi adicionado!");
                } else {
                    if (territorios.size() > 0) {
                        ldoAdd.setTerritorios(territorios);
                        ldos.add(ldoAdd);
                        ldoAdd = new Ldo();
                        territorios = new ArrayList<Territorio>();
                    } else {
                        FacesMessageUtils.error("Selecione um ou mais territórios!");
                    }

                }

            } else {
                FacesMessageUtils.error("O valor do LDO é obrigatório!");
            }
        } else {
            FacesMessageUtils.error("O ano do LDO é obrigatório!");
        }
    }

    public void removerLDO(Ldo ldo) {
        ldos.remove(ldo);
    }

    private boolean ldoJahAdicionado(Ldo ldo) {
        for (Ldo ldo1 : ldos) {
            if (ldo1.getAno().equals(ldo.getAno())) {
                return true;
            }
        }
        return false;
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
