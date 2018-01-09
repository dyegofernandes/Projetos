package br.com.weblicita.dao.cadastro.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.cadastro.TipoModalidadeDAO;
import br.com.weblicita.modelo.cadastro.TipoModalidade;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoModalidadeDAOImpl extends BaseDAOImpl<TipoModalidade> implements TipoModalidadeDAO {

    @Override
    public Class getEntityClass() {
        return TipoModalidade.class;
    }

}
