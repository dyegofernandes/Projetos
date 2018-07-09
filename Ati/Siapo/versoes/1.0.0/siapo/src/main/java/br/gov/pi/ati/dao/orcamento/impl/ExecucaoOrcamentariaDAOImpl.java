package br.gov.pi.ati.dao.orcamento.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.orcamento.ExecucaoOrcamentariaDAO;
import br.gov.pi.ati.modelo.orcamento.ExecucaoOrcamentaria;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ExecucaoOrcamentariaDAOImpl extends BaseDAOImpl<ExecucaoOrcamentaria> implements ExecucaoOrcamentariaDAO {

    @Override
    public Class getEntityClass() {
        return ExecucaoOrcamentaria.class;
    }

}
