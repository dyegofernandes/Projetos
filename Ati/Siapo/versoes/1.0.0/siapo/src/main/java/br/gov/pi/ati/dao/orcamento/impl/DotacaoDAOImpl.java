package br.gov.pi.ati.dao.orcamento.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.orcamento.DotacaoDAO;
import br.gov.pi.ati.modelo.orcamento.Dotacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DotacaoDAOImpl extends BaseDAOImpl<Dotacao> implements DotacaoDAO {

    @Override
    public Class getEntityClass() {
        return Dotacao.class;
    }

}
