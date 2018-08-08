package br.com.dizimo.dao.configuracao.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.configuracao.ErroSistemaDAO;
import br.com.dizimo.modelo.configuracao.ErroSistema;
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
