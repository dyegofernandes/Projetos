package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.OrgaoDAO;
import br.gov.pi.ati.modelo.cadastro.Orgao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrgaoDAOImpl extends BaseDAOImpl<Orgao> implements OrgaoDAO {

    @Override
    public Class getEntityClass() {
        return Orgao.class;
    }

}
