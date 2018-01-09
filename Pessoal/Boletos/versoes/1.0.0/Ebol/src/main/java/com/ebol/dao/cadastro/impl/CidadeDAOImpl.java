package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.CidadeDAO;
import com.ebol.modelo.cadastro.Cidade;
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
