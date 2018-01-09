package geradorne.geradorne.dao.controleacesso.impl;

import geradorne.geradorne.application.BaseDAOImpl;
import geradorne.geradorne.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import geradorne.geradorne.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
