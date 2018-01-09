package com.opfacil.dao.controleacesso.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import com.opfacil.modelo.controleacesso.HistoricoSituacaoUsuario;
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
