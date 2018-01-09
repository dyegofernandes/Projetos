package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.StatusViaturaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.StatusViatura;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class StatusViaturaDAOImpl extends BaseDAOImpl<StatusViatura> implements StatusViaturaDAO {

    @Override
    public Class getEntityClass() {
        return StatusViatura.class;
    }

}
