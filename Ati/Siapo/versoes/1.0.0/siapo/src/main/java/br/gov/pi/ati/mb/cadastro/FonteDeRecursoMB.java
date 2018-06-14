package br.gov.pi.ati.mb.cadastro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.cadastro.FonteDeRecursoBO;
import br.gov.pi.ati.modelo.cadastro.FonteDeRecurso;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
import com.xpert.faces.utils.FacesMessageUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FonteDeRecursoMB extends AbstractBaseBean<FonteDeRecurso> implements Serializable {
    
    private NaturezaDeDespesa naturezaDespesaAdd;
    
    private List<NaturezaDeDespesa> naturezasDespesas;
    
    @EJB
    private FonteDeRecursoBO fonteDeRecursoBO;
    
    @Override
    public FonteDeRecursoBO getBO() {
        return fonteDeRecursoBO;
    }
    
    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void init() {
        naturezasDespesas = new ArrayList<NaturezaDeDespesa>();
        
        if (getEntity().getId() != null) {
            naturezasDespesas = getDAO().getInitialized(getEntity().getNaturezasDeDespesas());
        }
    }
    
    @Override
    public void save() {
        getEntity().setNaturezasDeDespesas(naturezasDespesas);
        super.save(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addNaturezaDespesa() {
        if (naturezaDespesaAdd != null) {
            if (naturezaJahAdicionada(naturezaDespesaAdd)) {
                FacesMessageUtils.error("Natureza de Despesa já foi adicionada!");
            } else {
                naturezasDespesas.add(naturezaDespesaAdd);
                naturezaDespesaAdd = null;
            }
        } else {
            FacesMessageUtils.error("Natureza de Despesas é obrigatória!");
        }
    }
    
    public void removerNaturezaDespesa(NaturezaDeDespesa natureza) {
        naturezasDespesas.remove(natureza);
    }
    
    private boolean naturezaJahAdicionada(NaturezaDeDespesa natureza) {
        for (NaturezaDeDespesa naturezasDespesa : naturezasDespesas) {
            if (naturezasDespesa.equals(natureza)) {
                return true;
            }
        }
        
        return false;
    }
    
    public List<FonteDeRecurso> autocomplete(String nome) {
        return getBO().listarPeloNome(nome);
    }

    public NaturezaDeDespesa getNaturezaDespesaAdd() {
        return naturezaDespesaAdd;
    }

    public void setNaturezaDespesaAdd(NaturezaDeDespesa naturezaDespesaAdd) {
        this.naturezaDespesaAdd = naturezaDespesaAdd;
    }

    public List<NaturezaDeDespesa> getNaturezasDespesas() {
        return naturezasDespesas;
    }

    public void setNaturezasDespesas(List<NaturezaDeDespesa> naturezasDespesas) {
        this.naturezasDespesas = naturezasDespesas;
    }
    
    
}
