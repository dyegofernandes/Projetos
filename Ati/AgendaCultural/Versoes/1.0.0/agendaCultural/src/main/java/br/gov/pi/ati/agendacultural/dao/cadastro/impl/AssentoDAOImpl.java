package br.gov.pi.ati.agendacultural.dao.cadastro.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.cadastro.AssentoDAO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Assento;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AssentoDAOImpl extends BaseDAOImpl<Assento> implements AssentoDAO {

    @Override
    public Class getEntityClass() {
        return Assento.class;
    }

}
