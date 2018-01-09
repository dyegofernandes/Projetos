package br.com.jsoft.centralfinanceira.dao.financeiro.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.financeiro.ContasAPagarVencimentosBaixasDAO;
import br.com.jsoft.centralfinanceira.modelo.financeiro.ContasAPagarVencimentosBaixas;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContasAPagarVencimentosBaixasDAOImpl extends BaseDAOImpl<ContasAPagarVencimentosBaixas> implements ContasAPagarVencimentosBaixasDAO {

    @Override
    public Class getEntityClass() {
        return ContasAPagarVencimentosBaixas.class;
    }

}
