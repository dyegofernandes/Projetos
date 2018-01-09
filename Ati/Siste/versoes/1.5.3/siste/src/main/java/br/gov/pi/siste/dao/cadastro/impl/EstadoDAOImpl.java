package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.EstadoDAO;
import br.gov.pi.siste.modelo.cadastro.Estado;
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
