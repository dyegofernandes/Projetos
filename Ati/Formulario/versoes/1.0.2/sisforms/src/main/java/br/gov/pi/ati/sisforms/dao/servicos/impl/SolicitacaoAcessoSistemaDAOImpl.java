package br.gov.pi.ati.sisforms.dao.servicos.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.servicos.impl.SolicitacaoAcessoSistemaDAO;
import br.gov.pi.ati.sisforms.modelo.servicos.SolicitacaoAcessoSistema;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SolicitacaoAcessoSistemaDAOImpl extends BaseDAOImpl<SolicitacaoAcessoSistema> implements SolicitacaoAcessoSistemaDAO {

    @Override
    public Class getEntityClass() {
        return SolicitacaoAcessoSistema.class;
    }

}
