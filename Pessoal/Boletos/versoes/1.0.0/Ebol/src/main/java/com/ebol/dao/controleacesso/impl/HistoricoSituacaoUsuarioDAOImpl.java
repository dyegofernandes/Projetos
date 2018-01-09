package com.ebol.dao.controleacesso.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import com.ebol.modelo.controleacesso.HistoricoSituacaoUsuario;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class HistoricoSituacaoUsuarioDAOImpl extends BaseDAOImpl<HistoricoSituacaoUsuario> implements HistoricoSituacaoUsuarioDAO {

    @Override
    public Class getEntityClass() {
        return HistoricoSituacaoUsuario.class;
    }
}
