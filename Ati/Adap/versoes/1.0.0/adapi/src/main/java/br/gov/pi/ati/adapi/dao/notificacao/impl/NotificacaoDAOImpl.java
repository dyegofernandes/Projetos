package br.gov.pi.ati.adapi.dao.notificacao.impl;

import br.gov.pi.ati.adapi.application.BaseDAOImpl;
import br.gov.pi.ati.adapi.dao.notificacao.NotificacaoDAO;
import br.gov.pi.ati.adapi.modelo.notificacao.Notificacao;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class NotificacaoDAOImpl extends BaseDAOImpl<Notificacao> implements NotificacaoDAO {

    @Override
    public Class getEntityClass() {
        return Notificacao.class;
    }

}
