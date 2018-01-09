package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.SolicitacaoAcessoInfoFolhaDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoInfoFolha;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SolicitacaoAcessoInfoFolhaDAOImpl extends BaseDAOImpl<SolicitacaoAcessoInfoFolha> implements SolicitacaoAcessoInfoFolhaDAO {

    @Override
    public Class getEntityClass() {
        return SolicitacaoAcessoInfoFolha.class;
    }

}
