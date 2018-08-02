package br.com.ejccard.dao.cadastro.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.cadastro.ProdutoDAO;
import br.com.ejccard.modelo.cadastro.Produto;
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
