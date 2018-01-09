package br.gov.pi.ati.siopm.dao.ocorrencia.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.ocorrencia.OcorrenciaDAO;
import br.gov.pi.ati.siopm.modelo.ocorrencia.Ocorrencia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class OcorrenciaDAOImpl extends BaseDAOImpl<Ocorrencia> implements OcorrenciaDAO {

    @Override
    public Class getEntityClass() {
        return Ocorrencia.class;
    }

}
