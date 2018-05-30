package br.gov.pi.ati.dao.controleacesso.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import br.gov.pi.ati.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
