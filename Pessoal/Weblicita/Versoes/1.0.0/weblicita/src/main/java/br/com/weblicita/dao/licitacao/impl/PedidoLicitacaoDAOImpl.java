package br.com.weblicita.dao.licitacao.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.licitacao.PedidoLicitacaoDAO;
import br.com.weblicita.modelo.licitacao.PedidoLicitacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PedidoLicitacaoDAOImpl extends BaseDAOImpl<PedidoLicitacao> implements PedidoLicitacaoDAO {

    @Override
    public Class getEntityClass() {
        return PedidoLicitacao.class;
    }

}
