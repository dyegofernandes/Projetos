package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.ParametroSistemaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.ParametroSistema;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ParametroSistemaDAOImpl extends BaseDAOImpl<ParametroSistema> implements ParametroSistemaDAO {

    @Override
    public Class getEntityClass() {
        return ParametroSistema.class;
    }

}
