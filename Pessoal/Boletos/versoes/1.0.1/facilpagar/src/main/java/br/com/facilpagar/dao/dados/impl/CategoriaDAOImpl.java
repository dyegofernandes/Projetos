package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.CategoriaDAO;
import br.com.facilpagar.modelo.dados.Categoria;
import javax.ejb.Stateless;

/**
 *
 * @author jj
 */
@Stateless
public class CategoriaDAOImpl extends BaseDAOImpl<Categoria> implements CategoriaDAO {

    @Override
    public Class getEntityClass() {
        return Categoria.class;
    }

}
