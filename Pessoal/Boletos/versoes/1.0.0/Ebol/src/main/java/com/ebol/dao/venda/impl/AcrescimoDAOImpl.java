package com.ebol.dao.venda.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.venda.AcrescimoDAO;
import com.ebol.modelo.venda.Acrescimo;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AcrescimoDAOImpl extends BaseDAOImpl<Acrescimo> implements AcrescimoDAO {

    @Override
    public Class getEntityClass() {
        return Acrescimo.class;
    }

}
