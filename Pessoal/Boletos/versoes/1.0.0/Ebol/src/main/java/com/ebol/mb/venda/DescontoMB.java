package com.ebol.mb.venda;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.venda.DescontoBO;
import com.ebol.modelo.venda.Desconto;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class DescontoMB extends AbstractBaseBean<Desconto> implements Serializable {

    @EJB
    private DescontoBO descontoBO;

    @Override
    public DescontoBO getBO() {
        return descontoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
