package br.gov.pi.ati.salvavidas.dao.controleacesso.impl;

import br.gov.pi.ati.salvavidas.application.BaseDAOImpl;
import br.gov.pi.ati.salvavidas.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import br.gov.pi.ati.salvavidas.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
