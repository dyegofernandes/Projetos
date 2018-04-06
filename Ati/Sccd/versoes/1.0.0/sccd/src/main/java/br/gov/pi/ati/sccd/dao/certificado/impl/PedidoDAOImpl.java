package br.gov.pi.ati.sccd.dao.certificado.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.certificado.PedidoDAO;
import br.gov.pi.ati.sccd.modelo.certificado.Pedido;
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
