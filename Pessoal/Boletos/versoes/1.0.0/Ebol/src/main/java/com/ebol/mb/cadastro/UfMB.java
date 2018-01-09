package com.ebol.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.UfBO;
import com.ebol.modelo.cadastro.Uf;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class UfMB extends AbstractBaseBean<Uf> implements Serializable {

    @EJB
    private UfBO BO;

    @Override
    public UfBO getBO() {
        return BO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
