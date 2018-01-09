package br.com.dota2.dao.email.impl;

import br.com.dota2.application.BaseDAOImpl;
import br.com.dota2.dao.email.ConfiguracaoEmailDAO;
import br.com.dota2.modelo.email.ConfiguracaoEmail;
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
