package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.TelefoneDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Telefone;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TelefoneDAOImpl extends BaseDAOImpl<Telefone> implements TelefoneDAO {

    @Override
    public Class getEntityClass() {
        return Telefone.class;
    }

}
