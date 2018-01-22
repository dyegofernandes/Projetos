package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.AcaoOrcamentariaDAO;
import br.gov.pi.ati.modelo.cadastro.AcaoOrcamentaria;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AcaoOrcamentariaDAOImpl extends BaseDAOImpl<AcaoOrcamentaria> implements AcaoOrcamentariaDAO {

    @Override
    public Class getEntityClass() {
        return AcaoOrcamentaria.class;
    }

}
