package br.gov.pi.ati.dao.orcamento.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.orcamento.MetaProdutoDAO;
import br.gov.pi.ati.modelo.orcamento.MetaProduto;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MetaProdutoDAOImpl extends BaseDAOImpl<MetaProduto> implements MetaProdutoDAO {

    @Override
    public Class getEntityClass() {
        return MetaProduto.class;
    }

}
