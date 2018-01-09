package br.gov.pi.siste.dao.financeiro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.financeiro.SalarioMinimoDAO;
import br.gov.pi.siste.modelo.financeiro.SalarioMinimo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SalarioMinimoDAOImpl extends BaseDAOImpl<SalarioMinimo> implements SalarioMinimoDAO {

    @Override
    public Class getEntityClass() {
        return SalarioMinimo.class;
    }

}
