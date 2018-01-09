package com.opfacil.dao.controleacesso.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import com.opfacil.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
