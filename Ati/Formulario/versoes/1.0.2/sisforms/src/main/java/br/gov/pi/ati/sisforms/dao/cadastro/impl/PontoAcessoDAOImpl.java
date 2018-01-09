package br.gov.pi.ati.sisforms.dao.cadastro.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.cadastro.PontoAcessoDAO;
import br.gov.pi.ati.sisforms.modelo.cadastro.PontoAcesso;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PontoAcessoDAOImpl extends BaseDAOImpl<PontoAcesso> implements PontoAcessoDAO {

    @Override
    public Class getEntityClass() {
        return PontoAcesso.class;
    }

}
