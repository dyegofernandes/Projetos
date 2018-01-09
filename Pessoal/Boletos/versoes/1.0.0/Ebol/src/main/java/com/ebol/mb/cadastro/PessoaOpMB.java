package com.ebol.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.ebol.bo.cadastro.PessoaOpBO;
import com.ebol.modelo.cadastro.PessoaOp;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PessoaOpMB extends AbstractBaseBean<PessoaOp> implements Serializable {

    @EJB
    private PessoaOpBO pessoaOpBO;

    @Override
    public PessoaOpBO getBO() {
        return pessoaOpBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
