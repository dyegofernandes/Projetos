package br.gov.pi.ati.sccd.dao.certificado.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.certificado.impl.ContratoFornecedorDAO;
import br.gov.pi.ati.sccd.modelo.certificado.ContratoFornecedor;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ContratoFornecedorDAOImpl extends BaseDAOImpl<ContratoFornecedor> implements ContratoFornecedorDAO {

    @Override
    public Class getEntityClass() {
        return ContratoFornecedor.class;
    }

}
