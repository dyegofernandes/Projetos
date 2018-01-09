package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.GrupoContaFinanceiraBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoContaFinanceira;
import br.com.jsoft.centralfinanceira.util.SessaoUtils;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class GrupoContaFinanceiraMB extends AbstractBaseBean<GrupoContaFinanceira> implements Serializable {

    @EJB
    private GrupoContaFinanceiraBO grupoContaFinanceiraBO;

    @Override
    public GrupoContaFinanceiraBO getBO() {
        return grupoContaFinanceiraBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }

    @Override
    public void init() {
            Empresa empresa = grupoContaFinanceiraBO.getDAO().getInitialized(SessaoUtils.getUser().getEmpresa());
            getEntity().setEmpresa(empresa);
    }
}
