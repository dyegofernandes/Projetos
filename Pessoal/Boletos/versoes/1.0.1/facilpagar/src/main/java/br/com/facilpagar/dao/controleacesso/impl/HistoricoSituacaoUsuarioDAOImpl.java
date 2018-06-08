package br.com.facilpagar.dao.controleacesso.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import br.com.facilpagar.modelo.controleacesso.HistoricoSituacaoUsuario;
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
