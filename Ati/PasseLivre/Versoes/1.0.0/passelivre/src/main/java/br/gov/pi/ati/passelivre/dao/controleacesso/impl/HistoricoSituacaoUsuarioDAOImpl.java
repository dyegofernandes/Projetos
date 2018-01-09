package br.gov.pi.ati.passelivre.dao.controleacesso.impl;

import br.gov.pi.ati.passelivre.application.BaseDAOImpl;
import br.gov.pi.ati.passelivre.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import br.gov.pi.ati.passelivre.modelo.controleacesso.HistoricoSituacaoUsuario;
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
