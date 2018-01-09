package br.gov.pi.salvemaria.dao.cadastro.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.cadastro.EstadoDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Estado;
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
