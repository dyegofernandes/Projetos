package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.UnidadeGestoraDAO;
import br.gov.pi.ati.modelo.cadastro.UnidadeGestora;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeGestoraDAOImpl extends BaseDAOImpl<UnidadeGestora> implements UnidadeGestoraDAO {

    @Override
    public Class getEntityClass() {
        return UnidadeGestora.class;
    }

}
