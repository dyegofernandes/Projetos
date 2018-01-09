package br.gov.pi.ati.agendacultural.dao.eventos.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.eventos.PortfolioDAO;
import br.gov.pi.ati.agendacultural.modelo.eventos.Portfolio;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PortfolioDAOImpl extends BaseDAOImpl<Portfolio> implements PortfolioDAO {

    @Override
    public Class getEntityClass() {
        return Portfolio.class;
    }

}
