package br.com.jsoft.centralfinanceira.dao.financeiro.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.financeiro.CentroResultadosDAO;
import br.com.jsoft.centralfinanceira.modelo.financeiro.CentroResultados;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class CentroResultadosDAOImpl extends BaseDAOImpl<CentroResultados> implements CentroResultadosDAO {

    @Override
    public Class getEntityClass() {
        return CentroResultados.class;
    }

}
