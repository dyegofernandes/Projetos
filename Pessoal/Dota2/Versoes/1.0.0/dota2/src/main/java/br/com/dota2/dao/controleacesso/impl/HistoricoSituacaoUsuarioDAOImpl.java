package br.com.dota2.dao.controleacesso.impl;

import br.com.dota2.application.BaseDAOImpl;
import br.com.dota2.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import br.com.dota2.modelo.controleacesso.HistoricoSituacaoUsuario;
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
