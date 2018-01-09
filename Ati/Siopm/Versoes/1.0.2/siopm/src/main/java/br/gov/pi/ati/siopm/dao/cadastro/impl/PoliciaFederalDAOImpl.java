package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.PoliciaFederalDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaFederal;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PoliciaFederalDAOImpl extends BaseDAOImpl<PoliciaFederal> implements PoliciaFederalDAO {

    @Override
    public Class getEntityClass() {
        return PoliciaFederal.class;
    }

}
