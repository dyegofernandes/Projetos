package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.UnidadeOrcamentariaDAO;
import br.gov.pi.ati.modelo.cadastro.UnidadeOrcamentaria;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeOrcamentariaDAOImpl extends BaseDAOImpl<UnidadeOrcamentaria> implements UnidadeOrcamentariaDAO {

    @Override
    public Class getEntityClass() {
        return UnidadeOrcamentaria.class;
    }

}
