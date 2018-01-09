package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.DrogaOcorrenciaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrencia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DrogaOcorrenciaDAOImpl extends BaseDAOImpl<DrogaOcorrencia> implements DrogaOcorrenciaDAO {

    @Override
    public Class getEntityClass() {
        return DrogaOcorrencia.class;
    }

}
