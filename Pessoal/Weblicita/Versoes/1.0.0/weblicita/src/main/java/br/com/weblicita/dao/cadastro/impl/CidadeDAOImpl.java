package br.com.weblicita.dao.cadastro.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.cadastro.CidadeDAO;
import br.com.weblicita.modelo.cadastro.Cidade;
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
