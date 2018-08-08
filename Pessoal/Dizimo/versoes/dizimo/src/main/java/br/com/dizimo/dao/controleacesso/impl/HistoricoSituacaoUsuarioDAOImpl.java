package br.com.dizimo.dao.controleacesso.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import br.com.dizimo.modelo.controleacesso.HistoricoSituacaoUsuario;
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
