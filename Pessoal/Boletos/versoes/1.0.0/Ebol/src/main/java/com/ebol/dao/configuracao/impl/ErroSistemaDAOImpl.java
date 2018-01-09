package com.ebol.dao.configuracao.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.configuracao.ErroSistemaDAO;
import com.ebol.modelo.configuracao.ErroSistema;
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
