package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.EstabelecimentoDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Estabelecimento;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class EstabelecimentoDAOImpl extends BaseDAOImpl<Estabelecimento> implements EstabelecimentoDAO {

    @Override
    public Class getEntityClass() {
        return Estabelecimento.class;
    }

}
