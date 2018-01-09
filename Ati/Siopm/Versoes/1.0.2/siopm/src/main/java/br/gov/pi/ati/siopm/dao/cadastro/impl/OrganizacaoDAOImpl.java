package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.OrganizacaoDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Organizacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OrganizacaoDAOImpl extends BaseDAOImpl<Organizacao> implements OrganizacaoDAO {

    @Override
    public Class getEntityClass() {
        return Organizacao.class;
    }

}
