package br.gov.pi.ati.sisforms.dao.servicos.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.servicos.LocalReservaDAO;
import br.gov.pi.ati.sisforms.modelo.servicos.LocalReserva;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class LocalReservaDAOImpl extends BaseDAOImpl<LocalReserva> implements LocalReservaDAO {

    @Override
    public Class getEntityClass() {
        return LocalReserva.class;
    }

}
