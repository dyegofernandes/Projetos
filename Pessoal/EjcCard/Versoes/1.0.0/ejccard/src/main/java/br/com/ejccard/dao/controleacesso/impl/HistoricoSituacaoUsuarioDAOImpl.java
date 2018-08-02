package br.com.ejccard.dao.controleacesso.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import br.com.ejccard.modelo.controleacesso.HistoricoSituacaoUsuario;
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
