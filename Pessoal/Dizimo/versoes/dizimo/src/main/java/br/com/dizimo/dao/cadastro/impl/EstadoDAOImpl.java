package br.com.dizimo.dao.cadastro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.cadastro.EstadoDAO;
import br.com.dizimo.modelo.cadastro.Estado;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class EstadoDAOImpl extends BaseDAOImpl<Estado> implements EstadoDAO {

    @Override
    public Class getEntityClass() {
        return Estado.class;
    }

}
