package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.IdentidadeDeGeneroDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.IdentidadeDeGenero;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class IdentidadeDeGeneroDAOImpl extends BaseDAOImpl<IdentidadeDeGenero> implements IdentidadeDeGeneroDAO {

    @Override
    public Class getEntityClass() {
        return IdentidadeDeGenero.class;
    }

}
