package br.gov.pi.ati.sisrh.dao.email.impl;

import br.gov.pi.ati.sisrh.application.BaseDAOImpl;
import br.gov.pi.ati.sisrh.dao.email.ConfiguracaoEmailDAO;
import br.gov.pi.ati.sisrh.modelo.email.ConfiguracaoEmail;
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
