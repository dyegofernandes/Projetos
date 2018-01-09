package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.TransitoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Transito;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TransitoDAOImpl extends BaseDAOImpl<Transito> implements TransitoDAO {

    @Override
    public Class getEntityClass() {
        return Transito.class;
    }

}
