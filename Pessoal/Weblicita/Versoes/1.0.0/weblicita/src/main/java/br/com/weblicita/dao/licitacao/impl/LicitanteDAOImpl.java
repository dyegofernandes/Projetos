package br.com.weblicita.dao.licitacao.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.licitacao.LicitanteDAO;
import br.com.weblicita.modelo.licitacao.Licitante;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class LicitanteDAOImpl extends BaseDAOImpl<Licitante> implements LicitanteDAO {

    @Override
    public Class getEntityClass() {
        return Licitante.class;
    }

}
