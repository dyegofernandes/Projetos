package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.GrupoFornecedorDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoFornecedor;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class GrupoFornecedorDAOImpl extends BaseDAOImpl<GrupoFornecedor> implements GrupoFornecedorDAO {

    @Override
    public Class getEntityClass() {
        return GrupoFornecedor.class;
    }

}
