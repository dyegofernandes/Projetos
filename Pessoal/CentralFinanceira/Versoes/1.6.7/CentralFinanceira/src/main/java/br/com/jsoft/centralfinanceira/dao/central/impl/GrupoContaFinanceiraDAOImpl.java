package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.GrupoContaFinanceiraDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoContaFinanceira;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class GrupoContaFinanceiraDAOImpl extends BaseDAOImpl<GrupoContaFinanceira> implements GrupoContaFinanceiraDAO {

    @Override
    public Class getEntityClass() {
        return GrupoContaFinanceira.class;
    }

}
