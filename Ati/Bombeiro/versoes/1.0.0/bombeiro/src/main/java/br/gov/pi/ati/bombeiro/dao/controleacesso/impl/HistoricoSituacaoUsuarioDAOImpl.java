package br.gov.pi.ati.bombeiro.dao.controleacesso.impl;

import br.gov.pi.ati.bombeiro.application.BaseDAOImpl;
import br.gov.pi.ati.bombeiro.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import br.gov.pi.ati.bombeiro.modelo.controleacesso.HistoricoSituacaoUsuario;
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
