package br.gov.pi.ati.bombeiro.dao.configuracao.impl;

import br.gov.pi.ati.bombeiro.application.BaseDAOImpl;
import br.gov.pi.ati.bombeiro.dao.configuracao.ErroSistemaDAO;
import br.gov.pi.ati.bombeiro.modelo.configuracao.ErroSistema;
import javax.ejb.Stateless;

/**
 *
 * @author Ayslan
 */
@Stateless
public class ErroSistemaDAOImpl extends BaseDAOImpl<ErroSistema> implements ErroSistemaDAO {

    @Override
    public Class getEntityClass() {
        return ErroSistema.class;
    }
    
    
    
}
