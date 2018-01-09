package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.ResultadoOcorrenciaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.ResultadoOcorrencia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ResultadoOcorrenciaDAOImpl extends BaseDAOImpl<ResultadoOcorrencia> implements ResultadoOcorrenciaDAO {

    @Override
    public Class getEntityClass() {
        return ResultadoOcorrencia.class;
    }

}
