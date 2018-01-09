package br.com.dota2.dao.exemplo.impl;

import br.com.dota2.application.BaseDAOImpl;
import br.com.dota2.dao.exemplo.PessoaExemploDAO;
import br.com.dota2.modelo.exemplo.PessoaExemplo;
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
