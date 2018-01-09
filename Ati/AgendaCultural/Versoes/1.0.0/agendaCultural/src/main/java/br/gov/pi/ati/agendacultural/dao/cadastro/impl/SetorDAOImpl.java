package br.gov.pi.ati.agendacultural.dao.cadastro.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.cadastro.SetorDAO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.Setor;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SetorDAOImpl extends BaseDAOImpl<Setor> implements SetorDAO {

    @Override
    public Class getEntityClass() {
        return Setor.class;
    }

}
