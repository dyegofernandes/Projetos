package br.gov.pi.siste.mb.financeiro;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import com.xpert.faces.utils.FacesMessageUtils;
import com.xpert.persistence.exception.DeleteException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.financeiro.AliquotaInssBO;
import br.gov.pi.siste.bo.financeiro.TabelaInssBO;
import br.gov.pi.siste.modelo.financeiro.AliquotaInss;
import br.gov.pi.siste.modelo.financeiro.TabelaInss;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TabelaInssMB extends AbstractBaseBean<TabelaInss> implements Serializable {

    @EJB
    private TabelaInssBO tabelaInssBO;

    @EJB
    private AliquotaInssBO inssBO;

    private List<AliquotaInss> listaInss = new ArrayList<AliquotaInss>();

    private List<AliquotaInss> listaInssDeletados = new ArrayList<AliquotaInss>();

    private AliquotaInss aliquotaAdd;

    @Override
    public TabelaInssBO getBO() {
        return tabelaInssBO;
    }

    @Override
    public String getDataModelOrder() {
        return "anoDeVingencia DESC";
    }

    @Override
    public void init() {
        aliquotaAdd = new AliquotaInss();
        if (getEntity().getId() != null) {
            listaInss = inssBO.listarAliquotasPelaTabela(getEntity());
        }
    }

    public void buscarAliquotas(TabelaInss tabela) {
        listaInss = inssBO.listarAliquotasPelaTabela(tabela);
    }

    @Override
    public void postSave() {
        setEntity(new TabelaInss());
    }

    @Override
    public void save() {
        if (listaInss.size() > 2) {
            super.save();
            for (AliquotaInss listaIns : listaInss) {
                inssBO.getDAO().saveOrMerge(listaIns, true);
            }
            for (AliquotaInss listaIns : listaInssDeletados) {
                try {
                    inssBO.getDAO().remove(listaIns);
                } catch (DeleteException ex) {
                    Logger.getLogger(TabelaInssMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            FacesMessageUtils.error("A lista de Aliquota deveram ser maior que 2!");
        }
    }

    public List<AliquotaInss> getListaInss() {
        return listaInss;
    }

    public void setListaInss(List<AliquotaInss> listaInss) {
        this.listaInss = listaInss;
    }

    public AliquotaInss getAliquotaAdd() {
        return aliquotaAdd;
    }

    public void setAliquotaAdd(AliquotaInss aliquotaAdd) {
        this.aliquotaAdd = aliquotaAdd;
    }

    public void addItem() {
        aliquotaAdd.setTabelaInss(getEntity());

        if (aliquotaAdd.getSalarioFinal() != null && aliquotaAdd.getSalarioInicial() != null
                && aliquotaAdd.getValor() != null) {
            if (aliquotaAdd.getSalarioFinal().compareTo(aliquotaAdd.getSalarioInicial()) >= 0) {
                if (verificarIntervalo(aliquotaAdd.getSalarioInicial())) {
                    FacesMessageUtils.error("Já existem aliquotas cadastradas nesse intervalo!");
                } else {
                    if (verificarIntervalo(aliquotaAdd.getSalarioFinal())) {
                        FacesMessageUtils.error("Já existem aliquotas cadastradas nesse intervalo!");
                    } else {
                        listaInss.add(aliquotaAdd);
                        aliquotaAdd = new AliquotaInss();
                    }
                }
            } else {
                FacesMessageUtils.error("Salário final deve ser maior que o inicial!");
            }

        } else {
            FacesMessageUtils.error("Existem campos obrigatórios não preenchidos!");
        }

    }

    public void removerItem(AliquotaInss item) {
        if (item.getId() != null) {
            listaInssDeletados.add(item);
        }
        listaInss.remove(item);
    }

    private boolean verificarIntervalo(BigDecimal valor) {
        for (AliquotaInss listaIns : listaInss) {
            if (valor.compareTo(listaIns.getSalarioInicial()) >= 0 && valor.compareTo(listaIns.getSalarioFinal()) <= 0) {
                return true;
            }
        }
        return false;
    }
}
