package br.com.jsoft.centralfinanceira.dao.financeiro.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.financeiro.LancamentosDAO;
import br.com.jsoft.centralfinanceira.modelo.financeiro.Lancamentos;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class LancamentosDAOImpl extends BaseDAOImpl<Lancamentos> implements LancamentosDAO {

    @Override
    public Class getEntityClass() {
        return Lancamentos.class;
    }

}
