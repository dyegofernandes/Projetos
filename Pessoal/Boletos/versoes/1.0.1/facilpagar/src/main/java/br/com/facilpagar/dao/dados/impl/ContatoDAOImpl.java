package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.ContatoDAO;
import br.com.facilpagar.modelo.dados.Contato;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContatoDAOImpl extends BaseDAOImpl<Contato> implements ContatoDAO {

    @Override
    public Class getEntityClass() {
        return Contato.class;
    }

}
