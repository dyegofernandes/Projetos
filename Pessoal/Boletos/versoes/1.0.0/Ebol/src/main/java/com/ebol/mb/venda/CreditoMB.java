package com.ebol.mb.venda;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.venda.CreditoBO;
import com.ebol.modelo.venda.Credito;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class CreditoMB extends AbstractBaseBean<Credito> implements Serializable {

    @EJB
    private CreditoBO creditoBO;

    @Override
    public CreditoBO getBO() {
        return creditoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
