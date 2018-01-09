package com.ebol.dao.email.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.email.ConfiguracaoEmailDAO;
import com.ebol.modelo.email.ConfiguracaoEmail;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class ConfiguracaoEmailDAOImpl extends BaseDAOImpl<ConfiguracaoEmail> implements ConfiguracaoEmailDAO {

    @Override
    public Class getEntityClass() {
        return ConfiguracaoEmail.class;
    }
}
