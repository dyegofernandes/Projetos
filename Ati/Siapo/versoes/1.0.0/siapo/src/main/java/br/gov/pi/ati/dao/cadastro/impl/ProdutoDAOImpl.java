package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.ProdutoDAO;
import br.gov.pi.ati.modelo.cadastro.Produto;
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
