package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.OrgaoRecebedorDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.OrgaoRecebedor;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrgaoRecebedorDAOImpl extends BaseDAOImpl<OrgaoRecebedor> implements OrgaoRecebedorDAO {

    @Override
    public Class getEntityClass() {
        return OrgaoRecebedor.class;
    }

}
