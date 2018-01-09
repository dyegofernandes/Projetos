package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.CabinaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Cabina;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CabinaDAOImpl extends BaseDAOImpl<Cabina> implements CabinaDAO {

    @Override
    public Class getEntityClass() {
        return Cabina.class;
    }

}
