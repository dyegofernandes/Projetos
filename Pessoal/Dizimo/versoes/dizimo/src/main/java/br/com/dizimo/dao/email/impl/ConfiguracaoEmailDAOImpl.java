package br.com.dizimo.dao.email.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.email.ConfiguracaoEmailDAO;
import br.com.dizimo.modelo.email.ConfiguracaoEmail;
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
