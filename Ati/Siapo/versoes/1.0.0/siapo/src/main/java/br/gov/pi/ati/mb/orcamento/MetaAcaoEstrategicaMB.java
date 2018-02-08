package br.gov.pi.ati.mb.orcamento;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.MetaAcaoEstrategicaBO;
import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;
import br.gov.pi.ati.modelo.orcamento.ReceitaMetaAcaoEstrategica;
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

        if (getEntity().getId() != null) {
            receitas = getDAO().getInitialized(getEntity().getReceitas());
        }
    }

    @Override
    public void save() {
        getEntity().setReceitas(receitas);
        super.save(); //To change body of generated methods, choose Tools | Templates.
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

}
