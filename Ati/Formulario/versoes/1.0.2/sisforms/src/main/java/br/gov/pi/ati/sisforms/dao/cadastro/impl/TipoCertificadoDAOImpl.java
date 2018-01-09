package br.gov.pi.ati.sisforms.dao.cadastro.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.cadastro.TipoCertificadoDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.TipoCertificado;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoCertificadoDAOImpl extends BaseDAOImpl<TipoCertificado> implements TipoCertificadoDAO {

    @Override
    public Class getEntityClass() {
        return TipoCertificado.class;
    }

}
