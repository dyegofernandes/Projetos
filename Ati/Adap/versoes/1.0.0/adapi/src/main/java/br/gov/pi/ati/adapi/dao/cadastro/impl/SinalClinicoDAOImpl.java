package br.gov.pi.ati.adapi.dao.cadastro.impl;

import br.gov.pi.ati.adapi.application.BaseDAOImpl;
import br.gov.pi.ati.adapi.dao.cadastro.SinalClinicoDAO;
import br.gov.pi.ati.adapi.modelo.cadastro.SinalClinico;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class SinalClinicoDAOImpl extends BaseDAOImpl<SinalClinico> implements SinalClinicoDAO {

    @Override
    public Class getEntityClass() {
        return SinalClinico.class;
    }

}
