package com.opfacil.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.opfacil.bo.cadastro.MotivoPagamentoBO;
import com.opfacil.modelo.cadastro.MotivoPagamento;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class MotivoPagamentoMB extends AbstractBaseBean<MotivoPagamento> implements Serializable {

    @EJB
    private MotivoPagamentoBO motivoPagamentoBO;

    @Override
    public MotivoPagamentoBO getBO() {
        return motivoPagamentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new MotivoPagamento());
    }
    
    
}
