package br.com.facilpagar.dao.controleacesso.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import br.com.facilpagar.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
