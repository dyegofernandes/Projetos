package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.TerritorioPorCidadeDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.TerritorioPorCidade;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TerritorioPorCidadeDAOImpl extends BaseDAOImpl<TerritorioPorCidade> implements TerritorioPorCidadeDAO {

    @Override
    public Class getEntityClass() {
        return TerritorioPorCidade.class;
    }

}
