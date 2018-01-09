package br.gov.pi.ati.sisforms.dao.monitoramento.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.monitoramento.InterrupcaoPontoAcessoDAO;
import br.gov.pi.ati.sisforms.modelo.monitoramento.InterrupcaoPontoAcesso;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class InterrupcaoPontoAcessoDAOImpl extends BaseDAOImpl<InterrupcaoPontoAcesso> implements InterrupcaoPontoAcessoDAO {

    @Override
    public Class getEntityClass() {
        return InterrupcaoPontoAcesso.class;
    }

}
