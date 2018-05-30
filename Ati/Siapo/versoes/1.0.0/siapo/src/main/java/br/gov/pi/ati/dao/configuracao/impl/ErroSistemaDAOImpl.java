package br.gov.pi.ati.dao.configuracao.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.configuracao.ErroSistemaDAO;
import br.gov.pi.ati.modelo.configuracao.ErroSistema;
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
