package geradorne.geradorne.dao.controleacesso.impl;

import geradorne.geradorne.application.BaseDAOImpl;
import geradorne.geradorne.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import geradorne.geradorne.modelo.controleacesso.HistoricoSituacaoUsuario;
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
