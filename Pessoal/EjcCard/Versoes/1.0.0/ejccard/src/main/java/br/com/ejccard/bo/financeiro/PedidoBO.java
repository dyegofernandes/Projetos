package br.com.ejccard.bo.financeiro;

import com.xpert.core.crud.AbstractBusinessObject;
import br.com.ejccard.dao.financeiro.PedidoDAO;
import com.xpert.core.validation.UniqueField;
import com.xpert.core.exception.BusinessException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import br.com.ejccard.modelo.financeiro.Pedido;

/**
 *
 * @author Juniel
 */
@Stateless
public class PedidoBO extends AbstractBusinessObject<Pedido> {

    @EJB
    private PedidoDAO pedidoDAO;
    
    @Override
    public PedidoDAO getDAO() {
        return pedidoDAO;
    }

    @Override
    public List<UniqueField> getUniqueFields() {
        return null;
    }

    @Override
    public void validate(Pedido pedido) throws BusinessException {
    }

    @Override
    public boolean isAudit() {
        return true;
    }

}
