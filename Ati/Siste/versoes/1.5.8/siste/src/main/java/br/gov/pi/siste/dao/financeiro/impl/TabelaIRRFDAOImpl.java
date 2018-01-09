package br.gov.pi.siste.dao.financeiro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.financeiro.TabelaIRRFDAO;
import br.gov.pi.siste.modelo.financeiro.TabelaIRRF;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TabelaIRRFDAOImpl extends BaseDAOImpl<TabelaIRRF> implements TabelaIRRFDAO {

    @Override
    public Class getEntityClass() {
        return TabelaIRRF.class;
    }

}
