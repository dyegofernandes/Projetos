package br.gov.pi.ati.sisforms.dao.cadastro.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.cadastro.OrgaoDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.Orgao;
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
