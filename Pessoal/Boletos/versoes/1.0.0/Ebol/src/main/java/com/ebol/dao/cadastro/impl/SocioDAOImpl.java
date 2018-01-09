package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.SocioDAO;
import com.ebol.modelo.cadastro.Socio;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SocioDAOImpl extends BaseDAOImpl<Socio> implements SocioDAO {

    @Override
    public Class getEntityClass() {
        return Socio.class;
    }

}
