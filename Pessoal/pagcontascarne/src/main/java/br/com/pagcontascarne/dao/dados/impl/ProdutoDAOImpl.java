package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.ProdutoDAO;
import br.com.pagcontascarne.modelo.dados.Produto;
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
