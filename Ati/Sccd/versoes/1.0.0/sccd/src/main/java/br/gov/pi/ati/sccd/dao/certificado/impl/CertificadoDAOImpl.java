package br.gov.pi.ati.sccd.dao.certificado.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.certificado.CertificadoDAO;
import br.gov.pi.ati.sccd.modelo.certificado.Certificado;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CertificadoDAOImpl extends BaseDAOImpl<Certificado> implements CertificadoDAO {

    @Override
    public Class getEntityClass() {
        return Certificado.class;
    }

}
