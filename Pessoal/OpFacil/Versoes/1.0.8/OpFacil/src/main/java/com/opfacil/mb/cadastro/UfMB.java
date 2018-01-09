package com.opfacil.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.opfacil.bo.cadastro.UfBO;
import com.opfacil.modelo.cadastro.Uf;

/**
 *
 * @author KillerBeeTwo
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

    @Override
    public void postSave() {
        setEntity(new Uf());
    }
    
    
}
