package com.ebol.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.ContatoBO;
import com.ebol.modelo.cadastro.Contato;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ContatoMB extends AbstractBaseBean<Contato> implements Serializable {

    @EJB
    private ContatoBO contatoBO;

    @Override
    public ContatoBO getBO() {
        return contatoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
