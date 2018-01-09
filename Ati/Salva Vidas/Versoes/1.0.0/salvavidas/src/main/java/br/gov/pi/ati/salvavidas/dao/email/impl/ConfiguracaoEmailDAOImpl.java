package br.gov.pi.ati.salvavidas.dao.email.impl;

import br.gov.pi.ati.salvavidas.application.BaseDAOImpl;
import br.gov.pi.ati.salvavidas.dao.email.ConfiguracaoEmailDAO;
import br.gov.pi.ati.salvavidas.modelo.email.ConfiguracaoEmail;
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
