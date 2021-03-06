package br.com.jsoft.centralfinanceira.mb.central;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.InstrucaoCobrancaBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.InstrucaoCobranca;
import br.com.jsoft.centralfinanceira.util.SessaoUtils;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class InstrucaoCobrancaMB extends AbstractBaseBean<InstrucaoCobranca> implements Serializable {

    @EJB
    private InstrucaoCobrancaBO instrucaoCobrancaBO;

    @Override
    public InstrucaoCobrancaBO getBO() {
        return instrucaoCobrancaBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
    
    @Override
    public void init() {
        Empresa empresa = instrucaoCobrancaBO.getDAO().getInitialized(SessaoUtils.getUser().getEmpresa());
        getEntity().setEmpresa(empresa);

    }
}
