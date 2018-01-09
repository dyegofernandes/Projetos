package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.ContatoDAO;
import com.ebol.modelo.cadastro.Contato;
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
