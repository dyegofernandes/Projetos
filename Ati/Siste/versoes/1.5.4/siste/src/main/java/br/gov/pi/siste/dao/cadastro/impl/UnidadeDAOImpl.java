package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.UnidadeDAO;
import br.gov.pi.siste.modelo.cadastro.Unidade;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeDAOImpl extends BaseDAOImpl<Unidade> implements UnidadeDAO {

    @Override
    public Class getEntityClass() {
        return Unidade.class;
    }

}
