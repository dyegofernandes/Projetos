package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.FamiliarDAO;
import com.ebol.modelo.cadastro.Familiar;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FamiliarDAOImpl extends BaseDAOImpl<Familiar> implements FamiliarDAO {

    @Override
    public Class getEntityClass() {
        return Familiar.class;
    }

}
