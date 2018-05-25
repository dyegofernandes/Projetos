package br.gov.pi.ati.sisrh.mb.cadastro;

import br.gov.pi.ati.sisrh.bo.cadastro.FichaDeVisitaDomiciliarBO;
import br.gov.pi.ati.sisrh.modelo.cadastro.FichaDeVisitaDomiciliar;
import br.gov.pi.ati.sisrh.modelo.cadastro.ProcedimentoFichaDeVisitaLgbt;
import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FichaDeVisitaDomiciliarMB extends AbstractBaseBean<FichaDeVisitaDomiciliar> implements Serializable {
    
    @EJB
    private FichaDeVisitaDomiciliarBO fichaDeVisitaDomiciliarBO;
    
    private List<ProcedimentoFichaDeVisitaLgbt> procedimentos;
    
    private ProcedimentoFichaDeVisitaLgbt procedimento;
    
    public List<ProcedimentoFichaDeVisitaLgbt> getProcedimentos() {
        return procedimentos;
    }
    
    public void setProcedimentos(List<ProcedimentoFichaDeVisitaLgbt> procedimentos) {
        this.procedimentos = procedimentos;
    }
    
    public ProcedimentoFichaDeVisitaLgbt getProcedimento() {
        return procedimento;
    }
    
    public void setProcedimento(ProcedimentoFichaDeVisitaLgbt procedimento) {
        this.procedimento = procedimento;
    }
    
    @Override
    public FichaDeVisitaDomiciliarBO getBO() {
        return fichaDeVisitaDomiciliarBO;
    }
    
    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void init() {
        procedimento = new ProcedimentoFichaDeVisitaLgbt();
        if (getEntity().getId() != null) {
            procedimentos = getBO().getDAO().getInitialized(getEntity().getProcedimentos());
        } else {
            procedimentos = new ArrayList<ProcedimentoFichaDeVisitaLgbt>();
        }
    }
    
    @Override
    public void save() {
        getEntity().setProcedimentos(procedimentos);
        super.save(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void postSave() {
        procedimentos = new ArrayList<ProcedimentoFichaDeVisitaLgbt>();
        procedimento = new ProcedimentoFichaDeVisitaLgbt();
        setEntity(new FichaDeVisitaDomiciliar());
    }
    
    public void addProcedimento() {
        procedimentos.add(procedimento);
        procedimento = new ProcedimentoFichaDeVisitaLgbt();
    }
    
    public void removerProcedimento(ProcedimentoFichaDeVisitaLgbt procedimento) {
        procedimentos.remove(procedimento);
    }
}
