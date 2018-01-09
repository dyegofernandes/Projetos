package com.ebol.mb.venda;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.venda.OpLancadaBO;
import com.ebol.modelo.venda.OpLancada;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OpLancadaMB extends AbstractBaseBean<OpLancada> implements Serializable {

    @EJB
    private OpLancadaBO opLancadaBO;

    @Override
    public OpLancadaBO getBO() {
        return opLancadaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
