package br.gov.pi.siste.dao.financeiro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.financeiro.TabelaInssDAO;
import br.gov.pi.siste.modelo.financeiro.TabelaInss;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TabelaInssDAOImpl extends BaseDAOImpl<TabelaInss> implements TabelaInssDAO {

    @Override
    public Class getEntityClass() {
        return TabelaInss.class;
    }

}
