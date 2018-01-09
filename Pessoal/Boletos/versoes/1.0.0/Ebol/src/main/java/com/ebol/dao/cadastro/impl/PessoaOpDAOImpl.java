package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.PessoaOpDAO;
import com.ebol.modelo.cadastro.PessoaOp;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PessoaOpDAOImpl extends BaseDAOImpl<PessoaOp> implements PessoaOpDAO {

    @Override
    public Class getEntityClass() {
        return PessoaOp.class;
    }

}
