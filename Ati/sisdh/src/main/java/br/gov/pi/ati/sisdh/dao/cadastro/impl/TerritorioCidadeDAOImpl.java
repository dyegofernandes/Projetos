package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.TerritorioCidadeDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.TerritorioCidade;
import javax.ejb.Stateless;

/**
 *
 * @author ads01
 */
@Stateless
public class TerritorioCidadeDAOImpl extends BaseDAOImpl<TerritorioCidade> implements TerritorioCidadeDAO {

    @Override
    public Class getEntityClass() {
        return TerritorioCidade.class;
    }

}
