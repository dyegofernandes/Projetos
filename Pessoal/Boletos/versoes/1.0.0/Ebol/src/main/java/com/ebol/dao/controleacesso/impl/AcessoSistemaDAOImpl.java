package com.ebol.dao.controleacesso.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.controleacesso.AcessoSistemaDAO;
import com.ebol.modelo.controleacesso.AcessoSistema;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class AcessoSistemaDAOImpl extends BaseDAOImpl<AcessoSistema> implements AcessoSistemaDAO {

    @Override
    public Class getEntityClass() {
        return AcessoSistema.class;
    }
    
    
}
