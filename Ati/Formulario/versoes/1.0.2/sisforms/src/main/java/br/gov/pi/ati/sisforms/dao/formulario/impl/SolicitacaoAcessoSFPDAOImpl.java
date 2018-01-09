package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.SolicitacaoAcessoSFPDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.SolicitacaoAcessoSFP;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SolicitacaoAcessoSFPDAOImpl extends BaseDAOImpl<SolicitacaoAcessoSFP> implements SolicitacaoAcessoSFPDAO {

    @Override
    public Class getEntityClass() {
        return SolicitacaoAcessoSFP.class;
    }

}
