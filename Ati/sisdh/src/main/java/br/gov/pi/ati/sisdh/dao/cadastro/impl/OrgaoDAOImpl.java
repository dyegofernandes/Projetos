package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.OrgaoDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.Orgao;
import javax.ejb.Stateless;

/**
 *
 * @author ads01
 */
@Stateless
public class OrgaoDAOImpl extends BaseDAOImpl<Orgao> implements OrgaoDAO {

    @Override
    public Class getEntityClass() {
        return Orgao.class;
    }

}
