package br.com.ejccard.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.ejccard.bo.financeiro.MovimentoBO;
import br.com.ejccard.modelo.financeiro.Movimento;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class MovimentoMB extends AbstractBaseBean<Movimento> implements Serializable {

    @EJB
    private MovimentoBO movimentoBO;

    @Override
    public MovimentoBO getBO() {
        return movimentoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
