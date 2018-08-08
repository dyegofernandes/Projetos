package br.com.dizimo.dao.cadastro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.cadastro.CidadeDAO;
import br.com.dizimo.modelo.cadastro.Cidade;
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
