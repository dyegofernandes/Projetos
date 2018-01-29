package br.com.weblicita.dao.cadastro.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.cadastro.UnidadeDeMedidaDAO;
import br.com.weblicita.modelo.cadastro.UnidadeDeMedida;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeDeMedidaDAOImpl extends BaseDAOImpl<UnidadeDeMedida> implements UnidadeDeMedidaDAO {

    @Override
    public Class getEntityClass() {
        return UnidadeDeMedida.class;
    }

}
