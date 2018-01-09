package com.ebol.mb.venda;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.venda.AcrescimoBO;
import com.ebol.modelo.venda.Acrescimo;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class AcrescimoMB extends AbstractBaseBean<Acrescimo> implements Serializable {

    @EJB
    private AcrescimoBO acrescimoBO;

    @Override
    public AcrescimoBO getBO() {
        return acrescimoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
