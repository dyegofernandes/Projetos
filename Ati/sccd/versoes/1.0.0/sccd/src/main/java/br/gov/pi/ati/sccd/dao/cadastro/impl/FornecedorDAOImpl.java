package br.gov.pi.ati.sccd.dao.cadastro.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.cadastro.FornecedorDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.Fornecedor;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FornecedorDAOImpl extends BaseDAOImpl<Fornecedor> implements FornecedorDAO {

    @Override
    public Class getEntityClass() {
        return Fornecedor.class;
    }

}
