package geradorne.geradorne.dao.email.impl;

import geradorne.geradorne.application.BaseDAOImpl;
import geradorne.geradorne.dao.email.ConfiguracaoEmailDAO;
import geradorne.geradorne.modelo.email.ConfiguracaoEmail;
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
