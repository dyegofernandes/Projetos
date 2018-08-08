package br.com.dizimo.dao.controleacesso.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import br.com.dizimo.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
