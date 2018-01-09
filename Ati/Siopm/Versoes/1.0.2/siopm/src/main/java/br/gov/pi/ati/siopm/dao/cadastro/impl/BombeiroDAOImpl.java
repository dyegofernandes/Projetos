package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.BombeiroDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Bombeiro;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class BombeiroDAOImpl extends BaseDAOImpl<Bombeiro> implements BombeiroDAO {

    @Override
    public Class getEntityClass() {
        return Bombeiro.class;
    }

}
