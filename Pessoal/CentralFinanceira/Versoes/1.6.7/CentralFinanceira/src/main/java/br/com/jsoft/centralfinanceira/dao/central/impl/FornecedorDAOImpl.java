package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.FornecedorDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Fornecedor;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class FornecedorDAOImpl extends BaseDAOImpl<Fornecedor> implements FornecedorDAO {

    @Override
    public Class getEntityClass() {
        return Fornecedor.class;
    }

}
