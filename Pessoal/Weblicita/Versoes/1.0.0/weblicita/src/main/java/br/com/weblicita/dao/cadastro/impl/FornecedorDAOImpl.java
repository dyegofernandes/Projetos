package br.com.weblicita.dao.cadastro.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.cadastro.FornecedorDAO;
import br.com.weblicita.modelo.cadastro.Fornecedor;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FornecedorDAOImpl extends BaseDAOImpl<Fornecedor> implements FornecedorDAO {

    @Override
    public Class getEntityClass() {
        return Fornecedor.class;
    }

}
