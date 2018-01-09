package br.com.jsoft.centralfinanceira.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.jsoft.centralfinanceira.bo.financeiro.ContasAPagarVencimentosBO;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentos;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ContasAPagarVencimentosMB extends AbstractBaseBean<ContasAPagarVencimentos> implements Serializable {

    @EJB
    private ContasAPagarVencimentosBO contasAPagarVencimentosBO;

    @Override
    public ContasAPagarVencimentosBO getBO() {
        return contasAPagarVencimentosBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
