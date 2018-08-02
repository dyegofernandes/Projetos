package br.com.ejccard.dao.financeiro.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.financeiro.PedidoDAO;
import br.com.ejccard.modelo.financeiro.Pedido;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PedidoDAOImpl extends BaseDAOImpl<Pedido> implements PedidoDAO {

    @Override
    public Class getEntityClass() {
        return Pedido.class;
    }

}
