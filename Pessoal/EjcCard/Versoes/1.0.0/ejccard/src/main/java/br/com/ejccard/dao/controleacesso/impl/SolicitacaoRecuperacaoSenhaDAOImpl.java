package br.com.ejccard.dao.controleacesso.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import br.com.ejccard.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
