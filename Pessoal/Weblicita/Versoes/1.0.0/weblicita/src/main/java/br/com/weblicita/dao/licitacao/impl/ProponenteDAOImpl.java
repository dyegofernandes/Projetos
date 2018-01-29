package br.com.weblicita.dao.licitacao.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.licitacao.ProponenteDAO;
import br.com.weblicita.modelo.licitacao.Proponente;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProponenteDAOImpl extends BaseDAOImpl<Proponente> implements ProponenteDAO {

    @Override
    public Class getEntityClass() {
        return Proponente.class;
    }

}
