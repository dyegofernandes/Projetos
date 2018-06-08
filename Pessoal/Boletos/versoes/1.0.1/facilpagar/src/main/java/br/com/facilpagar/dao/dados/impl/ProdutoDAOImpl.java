package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.ProdutoDAO;
import br.com.facilpagar.modelo.dados.Produto;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProdutoDAOImpl extends BaseDAOImpl<Produto> implements ProdutoDAO {

    @Override
    public Class getEntityClass() {
        return Produto.class;
    }

}
