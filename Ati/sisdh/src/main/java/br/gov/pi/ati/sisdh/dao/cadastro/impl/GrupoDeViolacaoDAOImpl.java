package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.GrupoDeViolacaoDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.GrupoDeViolacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoDeViolacaoDAOImpl extends BaseDAOImpl<GrupoDeViolacao> implements GrupoDeViolacaoDAO {

    @Override
    public Class getEntityClass() {
        return GrupoDeViolacao.class;
    }

}
