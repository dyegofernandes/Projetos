package br.com.dizimo.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.dizimo.bo.financeiro.DizimoBO;
import br.com.dizimo.modelo.financeiro.Dizimo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DizimoMB extends AbstractBaseBean<Dizimo> implements Serializable {

    @EJB
    private DizimoBO dizimoBO;

    @Override
    public DizimoBO getBO() {
        return dizimoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
