package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.OpcDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Opc;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OpcDAOImpl extends BaseDAOImpl<Opc> implements OpcDAO {

    @Override
    public Class getEntityClass() {
        return Opc.class;
    }

}
