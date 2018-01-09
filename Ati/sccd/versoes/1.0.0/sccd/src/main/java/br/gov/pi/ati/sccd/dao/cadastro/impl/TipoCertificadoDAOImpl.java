package br.gov.pi.ati.sccd.dao.cadastro.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.cadastro.TipoCertificadoDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.TipoCertificado;
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
