package br.com.ejccard.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.ejccard.bo.financeiro.EstoqueBO;
import br.com.ejccard.modelo.financeiro.Estoque;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class EstoqueMB extends AbstractBaseBean<Estoque> implements Serializable {

    @EJB
    private EstoqueBO estoqueBO;

    @Override
    public EstoqueBO getBO() {
        return estoqueBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
