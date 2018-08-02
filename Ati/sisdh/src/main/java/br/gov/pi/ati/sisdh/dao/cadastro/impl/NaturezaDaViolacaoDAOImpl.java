package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.NaturezaDaViolacaoDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.NaturezaDaViolacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class NaturezaDaViolacaoDAOImpl extends BaseDAOImpl<NaturezaDaViolacao> implements NaturezaDaViolacaoDAO {

    @Override
    public Class getEntityClass() {
        return NaturezaDaViolacao.class;
    }

}
