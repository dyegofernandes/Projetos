package br.com.facilpagar.dao.email.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.email.ConfiguracaoEmailDAO;
import br.com.facilpagar.modelo.email.ConfiguracaoEmail;
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
