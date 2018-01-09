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
import br.gov.pi.siste.bo.financeiro.AliquotaIRRFBO;
import br.gov.pi.siste.bo.financeiro.TabelaIRRFBO;
import br.gov.pi.siste.modelo.financeiro.AliquotaIRRF;
import br.gov.pi.siste.modelo.financeiro.TabelaIRRF;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class TabelaIRRFMB extends AbstractBaseBean<TabelaIRRF> implements Serializable {

    @EJB
    private TabelaIRRFBO tabelaIRRFBO;

    @EJB
    private AliquotaIRRFBO irrfBO;

    private AliquotaIRRF irrfAdd;

    private List<AliquotaIRRF> listaIrrf = new ArrayList<AliquotaIRRF>();

    private List<AliquotaIRRF> listaIrrfDeletados = new ArrayList<AliquotaIRRF>();

    @Override
    public void init() {
        irrfAdd = new AliquotaIRRF();
        if (getEntity().getId() != null) {
            listaIrrf = irrfBO.listarAliquotasPelaTabela(getEntity());
        }
    }
    
    @Override
    public void postSave() {
        setEntity(new TabelaIRRF());
    }

    @Override
    public void save() {
        if (listaIrrf.size() > 2) {
            super.save();
            for (AliquotaIRRF listaIrrf1 : listaIrrf) {
                irrfBO.getDAO().saveOrMerge(listaIrrf1, true);
            }
            for (AliquotaIRRF listaIrrf1 : listaIrrfDeletados) {
                try {
                    irrfBO.getDAO().remove(listaIrrf1);
                } catch (DeleteException ex) {
                    Logger.getLogger(TabelaIRRFMB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            FacesMessageUtils.error("A lista de Aliquota deveram ser maior que 2!");
        }
    }

    public void addItem() {
        irrfAdd.setTabelaIRRF(getEntity());

        if (irrfAdd.getSalarioFinal() != null && irrfAdd.getSalarioInicial() != null
                && irrfAdd.getValor() != null) {
            if (irrfAdd.getSalarioFinal().compareTo(irrfAdd.getSalarioInicial()) >= 0) {
                if (verificarIntervalo(irrfAdd.getSalarioInicial())) {
                    FacesMessageUtils.error("Já existem aliquotas cadastradas nesse intervalo!");
                } else {
                    if (verificarIntervalo(irrfAdd.getSalarioFinal())) {
                        FacesMessageUtils.error("Já existem aliquotas cadastradas nesse intervalo!");
                    } else {
                        listaIrrf.add(irrfAdd);
                        irrfAdd = new AliquotaIRRF();
                    }
                }
            } else {
                FacesMessageUtils.error("Salário final deve ser maior que o inicial!");
            }

        } else {
            FacesMessageUtils.error("Existem campos obrigatórios não preenchidos!");
        }

    }

    public void removerItem(AliquotaIRRF item) {
        if (item.getId() != null) {
            listaIrrfDeletados.add(item);
        }
        listaIrrf.remove(item);
    }
    
    private boolean verificarIntervalo(BigDecimal valor) {
        for (AliquotaIRRF listaIns : listaIrrf) {
            if (valor.compareTo(listaIns.getSalarioInicial()) >= 0 && valor.compareTo(listaIns.getSalarioFinal()) <= 0) {
                return true;
            }
        }
        return false;
    }
    
    public void buscarAliquota(TabelaIRRF tabela){
        listaIrrf = irrfBO.listarAliquotasPelaTabela(tabela);
    }
    
    @Override
    public TabelaIRRFBO getBO() {
        return tabelaIRRFBO;
    }

    @Override
    public String getDataModelOrder() {
        return "anoDeVingencia DESC";
    }

    public AliquotaIRRF getIrrfAdd() {
        return irrfAdd;
    }

    public void setIrrfAdd(AliquotaIRRF irrfAdd) {
        this.irrfAdd = irrfAdd;
    }

    public List<AliquotaIRRF> getListaIrrf() {
        return listaIrrf;
    }

    public void setListaIrrf(List<AliquotaIRRF> listaIrrf) {
        this.listaIrrf = listaIrrf;
    }

}
