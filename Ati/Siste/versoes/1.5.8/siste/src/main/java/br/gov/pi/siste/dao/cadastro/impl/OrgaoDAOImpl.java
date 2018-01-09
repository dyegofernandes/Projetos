package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.OrgaoDAO;
import br.gov.pi.siste.modelo.cadastro.Orgao;
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
