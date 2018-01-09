package br.gov.pi.ati.siopm.mb.cadastro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.gov.pi.ati.siopm.bo.cadastro.OperacaoBO;
import br.gov.pi.ati.siopm.modelo.cadastro.Operacao;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class OperacaoMB extends AbstractBaseBean<Operacao> implements Serializable {

    @EJB
    private OperacaoBO operacaoBO;

    @Override
    public OperacaoBO getBO() {
        return operacaoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
