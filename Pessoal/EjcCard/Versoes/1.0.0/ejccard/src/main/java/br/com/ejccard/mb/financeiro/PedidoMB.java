package br.com.ejccard.mb.financeiro;


import java.io.Serializable;
import com.xpert.core.crud.AbstractBaseBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.ejccard.bo.financeiro.PedidoBO;
import br.com.ejccard.modelo.financeiro.Pedido;

/**
 *
 * @author Juniel
 */
@ManagedBean
@ViewScoped
public class PedidoMB extends AbstractBaseBean<Pedido> implements Serializable {

    @EJB
    private PedidoBO pedidoBO;

    @Override
    public PedidoBO getBO() {
        return pedidoBO;
    }

    @Override
    public String getDataModelOrder() {
        return "id";
    }
}
