package br.gov.pi.ati.sccd.dao.certificado.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.certificado.ItemPedidoDAO;
import br.gov.pi.ati.sccd.modelo.certificado.ItemPedido;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemPedidoDAOImpl extends BaseDAOImpl<ItemPedido> implements ItemPedidoDAO {

    @Override
    public Class getEntityClass() {
        return ItemPedido.class;
    }

}
