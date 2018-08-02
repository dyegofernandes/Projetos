package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.EstadoDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.Estado;
import javax.ejb.Stateless;

/**
 *
 * @author ads01
 */
@Stateless
public class EstadoDAOImpl extends BaseDAOImpl<Estado> implements EstadoDAO {

    @Override
    public Class getEntityClass() {
        return Estado.class;
    }

}
