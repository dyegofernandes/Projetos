package br.com.jsoft.centralfinanceira.mb.central;

import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.central.AgenteCobradorBO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.AgenteCobrador;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ContaFinanceira;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Empresa;
import br.com.jsoft.centralfinanceira.util.SessaoUtils;

/**
 *
 * @author KillerBeeTwo
 */
@ManagedBean
@ViewScoped
public class AgenteCobradorMB extends AbstractBaseBean<AgenteCobrador> implements Serializable {
    
    @EJB
    private AgenteCobradorBO agenteCobradorBO;
    
    @Override
    public AgenteCobradorBO getBO() {
        return agenteCobradorBO;
    }
    
    @Override
    public String getDataModelOrder() {
        return "nome";
    }
    
    @Override
    public void init() {
        Empresa empresa = agenteCobradorBO.getDAO().getInitialized(SessaoUtils.getUser().getEmpresa());
        getEntity().setEmpresa(empresa);
        
    }
    
    public void setarConta() {
        if (getEntity().getContaFinanceira() != null) {
            ContaFinanceira conta = agenteCobradorBO.getDAO().getInitialized(getEntity().getContaFinanceira());
            getEntity().setPrefAg(conta.getAgencia());
            getEntity().setConta(conta.getCc());
        }
    }
    
}
