package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.PendenciaIdentificadaDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.PendenciaIdentificada;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PendenciaIdentificadaDAOImpl extends BaseDAOImpl<PendenciaIdentificada> implements PendenciaIdentificadaDAO {

    @Override
    public Class getEntityClass() {
        return PendenciaIdentificada.class;
    }

}
