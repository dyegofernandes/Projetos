package com.ebol.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.Padrao_CobrancaBO;
import com.ebol.modelo.cadastro.Padrao_Cobranca;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class Padrao_CobrancaMB extends AbstractBaseBean<Padrao_Cobranca> implements Serializable {

    @EJB
    private Padrao_CobrancaBO padrao_CobrancaBO;

    @Override
    public Padrao_CobrancaBO getBO() {
        return padrao_CobrancaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
