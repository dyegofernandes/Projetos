package br.com.weblicita.dao.controleacesso.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import br.com.weblicita.modelo.controleacesso.HistoricoSituacaoUsuario;
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
