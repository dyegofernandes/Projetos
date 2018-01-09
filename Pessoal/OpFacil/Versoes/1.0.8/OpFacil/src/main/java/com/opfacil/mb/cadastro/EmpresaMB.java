package com.opfacil.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.opfacil.bo.cadastro.EmpresaBO;
import com.opfacil.modelo.cadastro.Empresa;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class EmpresaMB extends AbstractBaseBean<Empresa> implements Serializable {

    @EJB
    private EmpresaBO empresaBO;

    @Override
    public EmpresaBO getBO() {
        return empresaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void postSave() {
        setEntity(new Empresa());
    }
    
}
