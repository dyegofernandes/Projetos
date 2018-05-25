package br.gov.pi.ati.mb.orcamento;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.bo.orcamento.ProgramacaoFinanceiraBO;
import br.gov.pi.ati.modelo.orcamento.ProgramacaoFinanceira;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class ProgramacaoFinanceiraMB extends AbstractBaseBean<ProgramacaoFinanceira> implements Serializable {

    @EJB
    private ProgramacaoFinanceiraBO programacaoFinanceiraBO;

    @Override
    public ProgramacaoFinanceiraBO getBO() {
        return programacaoFinanceiraBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
