package br.com.weblicita.dao.licitacao.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.licitacao.ItemLicitacaoDAO;
import br.com.weblicita.modelo.licitacao.ItemLicitacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemLicitacaoDAOImpl extends BaseDAOImpl<ItemLicitacao> implements ItemLicitacaoDAO {

    @Override
    public Class getEntityClass() {
        return ItemLicitacao.class;
    }

}
