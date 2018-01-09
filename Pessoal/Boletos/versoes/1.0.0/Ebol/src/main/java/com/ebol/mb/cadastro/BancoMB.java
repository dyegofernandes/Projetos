package com.ebol.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.BancoBO;
import com.ebol.modelo.cadastro.Banco;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class BancoMB extends AbstractBaseBean<Banco> implements Serializable {

    @EJB
    private BancoBO bancoBO;

    @Override
    public BancoBO getBO() {
        return bancoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
