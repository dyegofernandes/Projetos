package com.ebol.dao.controleacesso.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import com.ebol.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
