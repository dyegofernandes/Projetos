package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.ConvenioDAO;
import com.ebol.modelo.cadastro.Convenio;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConvenioDAOImpl extends BaseDAOImpl<Convenio> implements ConvenioDAO {

    @Override
    public Class getEntityClass() {
        return Convenio.class;
    }

}
