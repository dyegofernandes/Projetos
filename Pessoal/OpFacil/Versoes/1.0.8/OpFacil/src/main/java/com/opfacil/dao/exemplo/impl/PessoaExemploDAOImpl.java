package com.opfacil.dao.exemplo.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.exemplo.PessoaExemploDAO;
import com.opfacil.modelo.exemplo.PessoaExemplo;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class PessoaExemploDAOImpl extends BaseDAOImpl<PessoaExemplo> implements PessoaExemploDAO {

    @Override
    public Class getEntityClass() {
        return PessoaExemplo.class;
    }

}
