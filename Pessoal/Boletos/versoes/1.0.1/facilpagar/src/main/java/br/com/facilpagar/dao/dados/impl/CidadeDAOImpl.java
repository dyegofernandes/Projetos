package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.CidadeDAO;
import br.com.facilpagar.modelo.dados.Cidade;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CidadeDAOImpl extends BaseDAOImpl<Cidade> implements CidadeDAO {

    @Override
    public Class getEntityClass() {
        return Cidade.class;
    }

}
