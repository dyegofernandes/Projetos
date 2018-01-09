package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.NaturezaOcorrenciaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.NaturezaOcorrencia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class NaturezaOcorrenciaDAOImpl extends BaseDAOImpl<NaturezaOcorrencia> implements NaturezaOcorrenciaDAO {

    @Override
    public Class getEntityClass() {
        return NaturezaOcorrencia.class;
    }

}
