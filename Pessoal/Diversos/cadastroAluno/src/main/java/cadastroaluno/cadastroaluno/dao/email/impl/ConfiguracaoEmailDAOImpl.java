package cadastroaluno.cadastroaluno.dao.email.impl;

import cadastroaluno.cadastroaluno.application.BaseDAOImpl;
import cadastroaluno.cadastroaluno.dao.email.ConfiguracaoEmailDAO;
import cadastroaluno.cadastroaluno.modelo.email.ConfiguracaoEmail;
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
