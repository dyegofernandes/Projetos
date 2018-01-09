package br.gov.pi.salvemaria.dao.controleacesso.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.controleacesso.SolicitacaoRecuperacaoSenhaDAO;
import br.gov.pi.salvemaria.modelo.controleacesso.SolicitacaoRecuperacaoSenha;
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
