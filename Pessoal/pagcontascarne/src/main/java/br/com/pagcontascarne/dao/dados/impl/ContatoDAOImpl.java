package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.ContatoDAO;
import br.com.pagcontascarne.modelo.dados.Contato;
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
