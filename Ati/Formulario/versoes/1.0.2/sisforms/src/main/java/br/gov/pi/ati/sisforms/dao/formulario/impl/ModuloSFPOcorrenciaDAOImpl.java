package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.ModuloSFPOcorrenciaDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.ModuloSFPOcorrencia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ModuloSFPOcorrenciaDAOImpl extends BaseDAOImpl<ModuloSFPOcorrencia> implements ModuloSFPOcorrenciaDAO {

    @Override
    public Class getEntityClass() {
        return ModuloSFPOcorrencia.class;
    }

}
