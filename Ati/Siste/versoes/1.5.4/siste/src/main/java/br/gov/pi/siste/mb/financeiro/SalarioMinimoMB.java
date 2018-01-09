package br.gov.pi.siste.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.siste.bo.financeiro.SalarioMinimoBO;
import br.gov.pi.siste.modelo.financeiro.SalarioMinimo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class SalarioMinimoMB extends AbstractBaseBean<SalarioMinimo> implements Serializable {

    @EJB
    private SalarioMinimoBO salarioMinimoBO;

    @Override
    public SalarioMinimoBO getBO() {
        return salarioMinimoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "anoDeVingencia DESC";
    }
    
    @Override
    public void postSave() {
        setEntity(new SalarioMinimo());
    }
}
