package br.gov.pi.ati.passelivre.dao.email.impl;

import br.gov.pi.ati.passelivre.application.BaseDAOImpl;
import br.gov.pi.ati.passelivre.dao.email.ConfiguracaoEmailDAO;
import br.gov.pi.ati.passelivre.modelo.email.ConfiguracaoEmail;
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
