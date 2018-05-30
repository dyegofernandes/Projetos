package br.gov.pi.ati.mb.orcamento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.MetaProdutoBO;
import br.gov.pi.ati.modelo.cadastro.Territorio;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.orcamento.Ldo;
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

    private Filtros filtros;

    private List<Ldo> ldos;

    private Ldo ldoAdd;

    private List<TerritorioPPA> territorios;

    private TerritorioPPA territorioAdd;

    private List<MetaProduto> produdos;

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
        getEntity().setTerritorios(territorios);
        super.save();
    }

    @Override
    public void init() {
        ldos = new ArrayList<Ldo>();
        ldoAdd = new Ldo();

        territorios = new ArrayList<TerritorioPPA>();
        territorioAdd = new TerritorioPPA();

        filtros = new Filtros();
        filtros.setUnidadesOrcamentaria(getDAO().getInitialized(SessaoUtils.getUser().getUnidadesDeAcesso()));

        if (getEntity().getId() != null) {
            ldos = getDAO().getInitialized(getEntity().getLdos());
            territorios = getDAO().getInitialized(getEntity().getTerritorios());
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

    public void addLDO() {
        if (ldoAdd.getAno() != null) {
            if (ldoAdd.getValor() != null) {
                if (ldoJahAdicionado(ldoAdd)) {
                    FacesMessageUtils.error("O valor referente para o ano informado já foi adicionado!");
                } else {
                    ldos.add(ldoAdd);
                    ldoAdd = new Ldo();
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

    public void addTerritorio() {
        if (territorioAdd.getTerritorio() != null) {
            if (territorioAdd.getValor() != null) {
                if (territorioJahAdiconado(territorioAdd.getTerritorio())) {
                    FacesMessageUtils.error("O valor para esse Território já foi adiconado!");
                } else {
                    territorios.add(territorioAdd);
                    territorioAdd = new TerritorioPPA();
                }
            } else {
                FacesMessageUtils.error("O valor para o Território selecionado é obrigatório!");
            }
        } else {
            FacesMessageUtils.error("Território é obrigatório!");
        }
    }

    public void removerTerritorio(TerritorioPPA territorio) {
        territorios.remove(territorio);
    }

    private boolean territorioJahAdiconado(Territorio territorio) {
        for (TerritorioPPA territorioPPA : territorios) {
            if (territorioPPA.getTerritorio().equals(territorio)) {
                return true;
            }
        }
        return false;
    }

    public void buscar() {
        produdos = getBO().listar(filtros);
    }
}
