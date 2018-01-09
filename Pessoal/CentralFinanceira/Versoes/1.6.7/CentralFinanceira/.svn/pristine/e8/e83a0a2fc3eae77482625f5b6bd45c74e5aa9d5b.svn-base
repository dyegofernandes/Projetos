package br.com.jsoft.centralfinanceira.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.financeiro.ContasAPagarVencimentosBaixasBO;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentosBaixas;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ContasAPagarVencimentosBaixasMB extends AbstractBaseBean<ContasAPagarVencimentosBaixas> implements Serializable {

    @EJB
    private ContasAPagarVencimentosBaixasBO contasAPagarVencimentosBaixasBO;

    @Override
    public ContasAPagarVencimentosBaixasBO getBO() {
        return contasAPagarVencimentosBaixasBO;
    }

    @Override
    public String getDataModelOrder() {
        return "dataVencimento";
    }
}
