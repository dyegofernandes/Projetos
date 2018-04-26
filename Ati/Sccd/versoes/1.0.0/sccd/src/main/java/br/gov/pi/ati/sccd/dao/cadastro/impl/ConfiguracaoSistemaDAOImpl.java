package br.gov.pi.ati.sccd.dao.cadastro.impl;

import br.gov.pi.ati.sccd.application.BaseDAOImpl;
import br.gov.pi.ati.sccd.dao.cadastro.ConfiguracaoSistemaDAO;
import br.gov.pi.ati.sccd.modelo.cadastro.ConfiguracaoSistema;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ConfiguracaoSistemaDAOImpl extends BaseDAOImpl<ConfiguracaoSistema> implements ConfiguracaoSistemaDAO {

    @Override
    public Class getEntityClass() {
        return ConfiguracaoSistema.class;
    }

}
