package br.com.weblicita.dao.cadastro.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.cadastro.RubricaOrcamentariaDAO;
import br.com.weblicita.modelo.cadastro.RubricaOrcamentaria;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class RubricaOrcamentariaDAOImpl extends BaseDAOImpl<RubricaOrcamentaria> implements RubricaOrcamentariaDAO {

    @Override
    public Class getEntityClass() {
        return RubricaOrcamentaria.class;
    }

}
