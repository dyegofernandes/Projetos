package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.SistemaDAO;
import br.com.facilpagar.modelo.dados.Sistema;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SistemaDAOImpl extends BaseDAOImpl<Sistema> implements SistemaDAO {

    @Override
    public Class getEntityClass() {
        return Sistema.class;
    }

}
