package br.com.weblicita.dao.licitacao.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.licitacao.PesquisaDePrecoDAO;
import br.com.weblicita.modelo.licitacao.PesquisaDePreco;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PesquisaDePrecoDAOImpl extends BaseDAOImpl<PesquisaDePreco> implements PesquisaDePrecoDAO {

    @Override
    public Class getEntityClass() {
        return PesquisaDePreco.class;
    }

}
