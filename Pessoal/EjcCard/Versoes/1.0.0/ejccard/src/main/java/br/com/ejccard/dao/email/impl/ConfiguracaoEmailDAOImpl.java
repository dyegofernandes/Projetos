package br.com.ejccard.dao.email.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.email.ConfiguracaoEmailDAO;
import br.com.ejccard.modelo.email.ConfiguracaoEmail;
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
