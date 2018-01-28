package br.com.weblicita.dao.licitacao.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.licitacao.IntencaoDeRegistroDePrecoDAO;
import br.com.weblicita.modelo.licitacao.IntencaoDeRegistroDePreco;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class IntencaoDeRegistroDePrecoDAOImpl extends BaseDAOImpl<IntencaoDeRegistroDePreco> implements IntencaoDeRegistroDePrecoDAO {

    @Override
    public Class getEntityClass() {
        return IntencaoDeRegistroDePreco.class;
    }

}
