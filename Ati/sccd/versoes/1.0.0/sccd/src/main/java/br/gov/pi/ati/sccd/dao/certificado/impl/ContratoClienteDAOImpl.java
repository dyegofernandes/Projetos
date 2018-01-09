package br.gov.pi.ati.sccd.dao.certificado.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.certificado.impl.ContratoClienteDAO;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoCliente;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContratoClienteDAOImpl extends BaseDAOImpl<ContratoCliente> implements ContratoClienteDAO {

    @Override
    public Class getEntityClass() {
        return ContratoCliente.class;
    }

}
