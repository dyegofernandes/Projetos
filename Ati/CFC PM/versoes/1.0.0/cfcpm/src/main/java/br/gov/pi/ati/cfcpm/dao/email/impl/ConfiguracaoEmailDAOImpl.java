package br.gov.pi.ati.cfcpm.dao.email.impl;

import br.gov.pi.ati.cfcpm.application.BaseDAOImpl;
import br.gov.pi.ati.cfcpm.dao.email.ConfiguracaoEmailDAO;
import br.gov.pi.ati.cfcpm.modelo.email.ConfiguracaoEmail;
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
