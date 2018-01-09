package br.gov.pi.ati.bombeiro.dao.controleacesso.impl;

import br.gov.pi.ati.bombeiro.application.BaseDAOImpl;
import br.gov.pi.ati.bombeiro.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class SolicitacaoRecuperacaoSenhaDAOImpl extends BaseDAOImpl<SolicitacaoRecuperacaoSenha> implements SolicitacaoRecuperacaoSenhaDAO {

    @Override
    public Class getEntityClass() {
        return SolicitacaoRecuperacaoSenha.class;
    }
}
