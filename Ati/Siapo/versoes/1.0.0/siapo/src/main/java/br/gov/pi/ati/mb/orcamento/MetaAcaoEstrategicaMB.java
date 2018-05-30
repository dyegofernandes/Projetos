package br.gov.pi.ati.mb.orcamento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.MetaAcaoEstrategicaBO;
import br.gov.pi.ati.modelo.cadastro.vos.Filtros;
import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;
import br.gov.pi.ati.modelo.orcamento.ReceitaMetaAcaoEstrategica;
import br.gov.pi.ati.util.SessaoUtils;
import br.gov.pi.ati.util.Utils;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MetaAcaoEstrategicaMB extends AbstractBaseBean<MetaAcaoEstrategica> implements Serializable {

    @EJB
    private MetaAcaoEstrategicaBO metaAcaoEstrategicaBO;

    private ReceitaMetaAcaoEstrategica receitaAdd;

    private List<ReceitaMetaAcaoEstrategica> receitas;

    private List<MetaAcaoEstrategica> metas;

    private Filtros filtros;

    @Override
    public MetaAcaoEstrategicaBO getBO() {
        return metaAcaoEstrategicaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
        receitaAdd = new ReceitaMetaAcaoEstrategica();
        receitas = new ArrayList<ReceitaMetaAcaoEstrategica>();
        metas = new ArrayList<MetaAcaoEstrategica>();
        filtros = new Filtros();
        filtros.setUnidadesOrcamentaria(getDAO().getInitialized(SessaoUtils.getUser().getUnidadesDeAcesso()));

        if (getEntity().getId() != null) {
            receitas = getDAO().getInitialized(getEntity().getReceitas());
        }
    }

    @Override
    public void save() {
        getEntity().setReceitas(receitas);
        super.save();
    }

    public ReceitaMetaAcaoEstrategica getReceitaAdd() {
        return receitaAdd;
    }

    public void setReceitaAdd(ReceitaMetaAcaoEstrategica receitaAdd) {
        this.receitaAdd = receitaAdd;
    }

    public List<ReceitaMetaAcaoEstrategica> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<ReceitaMetaAcaoEstrategica> receitas) {
        this.receitas = receitas;
    }

    public List<MetaAcaoEstrategica> getMetas() {
        return metas;
    }

    public void setMetas(List<MetaAcaoEstrategica> metas) {
        this.metas = metas;
    }

    public Filtros getFiltros() {
        return filtros;
    }

    public void setFiltros(Filtros filtros) {
        this.filtros = filtros;
    }

    public void addReceita() {
        if (!Utils.isNullOrEmpty(receitaAdd.getNome())) {
            if (jahAdicionada(receitaAdd.getNome())) {
                FacesMessageUtils.error("Já foi encontrado uma Receita com esse nome na lista!");
            } else {
                if (receitaAdd.getValor() != null) {
                    receitas.add(receitaAdd);
                    receitaAdd = new ReceitaMetaAcaoEstrategica();
                } else {
                    FacesMessageUtils.error("Nome é obrigatório!");
                }
            }
        } else {
            FacesMessageUtils.error("Nome é obrigatório!");
        }
    }

    public void removerReceita(ReceitaMetaAcaoEstrategica receita) {
        receitas.remove(receita);
    }

    private boolean jahAdicionada(String nome) {
        for (ReceitaMetaAcaoEstrategica receita : receitas) {
            if (receita.getNome().toUpperCase().equals(nome.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public void buscar() {
        metas = metaAcaoEstrategicaBO.listar(filtros);
    }
}
