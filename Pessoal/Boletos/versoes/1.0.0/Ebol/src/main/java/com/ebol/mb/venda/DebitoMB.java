package com.ebol.mb.venda;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.venda.DebitoBO;
import com.ebol.modelo.venda.Debito;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DebitoMB extends AbstractBaseBean<Debito> implements Serializable {

    @EJB
    private DebitoBO debitoBO;

    @Override
    public DebitoBO getBO() {
        return debitoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
