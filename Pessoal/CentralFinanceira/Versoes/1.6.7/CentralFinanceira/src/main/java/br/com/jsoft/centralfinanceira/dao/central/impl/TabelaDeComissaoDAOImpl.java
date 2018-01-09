package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.TabelaDeComissaoDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.TabelaDeComissao;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class TabelaDeComissaoDAOImpl extends BaseDAOImpl<TabelaDeComissao> implements TabelaDeComissaoDAO {

    @Override
    public Class getEntityClass() {
        return TabelaDeComissao.class;
    }

}
