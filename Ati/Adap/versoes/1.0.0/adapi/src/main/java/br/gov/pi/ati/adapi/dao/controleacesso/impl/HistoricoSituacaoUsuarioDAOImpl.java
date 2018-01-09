package br.gov.pi.ati.adapi.dao.controleacesso.impl;

import br.gov.pi.ati.adapi.application.BaseDAOImpl;
import br.gov.pi.ati.adapi.dao.controleacesso.HistoricoSituacaoUsuarioDAO;
import br.gov.pi.ati.adapi.modelo.controleacesso.HistoricoSituacaoUsuario;
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
