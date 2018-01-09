package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.PatrulhaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Patrulha;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PatrulhaDAOImpl extends BaseDAOImpl<Patrulha> implements PatrulhaDAO {

    @Override
    public Class getEntityClass() {
        return Patrulha.class;
    }

}
