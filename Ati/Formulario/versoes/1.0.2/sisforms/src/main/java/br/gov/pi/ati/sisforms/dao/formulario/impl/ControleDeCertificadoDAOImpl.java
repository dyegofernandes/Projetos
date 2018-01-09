package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.ControleDeCertificadoDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.ControleDeCertificado;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ControleDeCertificadoDAOImpl extends BaseDAOImpl<ControleDeCertificado> implements ControleDeCertificadoDAO {

    @Override
    public Class getEntityClass() {
        return ControleDeCertificado.class;
    }

}
