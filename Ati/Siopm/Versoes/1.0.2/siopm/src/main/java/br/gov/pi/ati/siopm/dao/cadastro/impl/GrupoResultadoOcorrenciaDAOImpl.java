package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.GrupoResultadoOcorrenciaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.GrupoResultadoOcorrencia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoResultadoOcorrenciaDAOImpl extends BaseDAOImpl<GrupoResultadoOcorrencia> implements GrupoResultadoOcorrenciaDAO {

    @Override
    public Class getEntityClass() {
        return GrupoResultadoOcorrencia.class;
    }

}
