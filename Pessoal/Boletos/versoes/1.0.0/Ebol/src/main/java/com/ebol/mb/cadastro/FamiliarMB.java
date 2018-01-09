package com.ebol.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.FamiliarBO;
import com.ebol.modelo.cadastro.Familiar;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class FamiliarMB extends AbstractBaseBean<Familiar> implements Serializable {

    @EJB
    private FamiliarBO familiarBO;

    @Override
    public FamiliarBO getBO() {
        return familiarBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
