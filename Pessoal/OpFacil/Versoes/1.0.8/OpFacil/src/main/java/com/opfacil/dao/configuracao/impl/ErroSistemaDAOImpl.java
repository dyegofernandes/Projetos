package com.opfacil.dao.configuracao.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.configuracao.ErroSistemaDAO;
import com.opfacil.modelo.configuracao.ErroSistema;
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
