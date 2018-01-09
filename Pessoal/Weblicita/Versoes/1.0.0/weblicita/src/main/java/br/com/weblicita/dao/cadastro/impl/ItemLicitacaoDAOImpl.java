package br.com.weblicita.dao.cadastro.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.cadastro.ItemLicitacaoDAO;
import br.com.weblicita.modelo.cadastro.Item;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ItemLicitacaoDAOImpl extends BaseDAOImpl<Item> implements ItemLicitacaoDAO {

    @Override
    public Class getEntityClass() {
        return Item.class;
    }

}
