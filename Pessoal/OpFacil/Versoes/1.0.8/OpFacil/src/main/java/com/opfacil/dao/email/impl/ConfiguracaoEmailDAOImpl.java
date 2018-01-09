package com.opfacil.dao.email.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.email.ConfiguracaoEmailDAO;
import com.opfacil.modelo.email.ConfiguracaoEmail;
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
