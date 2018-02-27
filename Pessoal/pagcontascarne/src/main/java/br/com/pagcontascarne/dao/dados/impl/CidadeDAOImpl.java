package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.CidadeDAO;
import br.com.pagcontascarne.modelo.dados.Cidade;
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
