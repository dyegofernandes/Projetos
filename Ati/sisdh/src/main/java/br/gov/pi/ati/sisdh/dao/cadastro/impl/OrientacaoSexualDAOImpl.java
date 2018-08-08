package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.OrientacaoSexualDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.OrientacaoSexual;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrientacaoSexualDAOImpl extends BaseDAOImpl<OrientacaoSexual> implements OrientacaoSexualDAO {

    @Override
    public Class getEntityClass() {
        return OrientacaoSexual.class;
    }

}
