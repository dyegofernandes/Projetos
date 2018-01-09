package br.gov.pi.siste.dao.financeiro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.financeiro.MovimentoDAO;
import br.gov.pi.siste.modelo.financeiro.Movimento;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MovimentoDAOImpl extends BaseDAOImpl<Movimento> implements MovimentoDAO {

    @Override
    public Class getEntityClass() {
        return Movimento.class;
    }

}
