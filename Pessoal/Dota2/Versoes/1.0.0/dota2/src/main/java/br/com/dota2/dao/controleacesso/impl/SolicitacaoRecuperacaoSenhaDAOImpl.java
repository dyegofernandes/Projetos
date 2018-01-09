package br.com.dota2.dao.controleacesso.impl;

import br.com.dota2.application.BaseDAOImpl;
import br.com.dota2.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import br.com.dota2.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
