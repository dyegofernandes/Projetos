package br.gov.pi.ati.dao.orcamento.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.orcamento.ProgramacaoFinanceiraDAO;
import br.gov.pi.ati.modelo.orcamento.ProgramacaoFinanceira;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProgramacaoFinanceiraDAOImpl extends BaseDAOImpl<ProgramacaoFinanceira> implements ProgramacaoFinanceiraDAO {

    @Override
    public Class getEntityClass() {
        return ProgramacaoFinanceira.class;
    }

}
