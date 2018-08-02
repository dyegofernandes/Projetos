package br.com.ejccard.dao.configuracao.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.configuracao.ErroSistemaDAO;
import br.com.ejccard.modelo.configuracao.ErroSistema;
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
