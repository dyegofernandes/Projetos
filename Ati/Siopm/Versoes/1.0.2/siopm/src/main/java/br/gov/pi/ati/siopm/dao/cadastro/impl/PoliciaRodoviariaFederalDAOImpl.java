package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.PoliciaRodoviariaFederalDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.PoliciaRodoviariaFederal;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class PoliciaRodoviariaFederalDAOImpl extends BaseDAOImpl<PoliciaRodoviariaFederal> implements PoliciaRodoviariaFederalDAO {

    @Override
    public Class getEntityClass() {
        return PoliciaRodoviariaFederal.class;
    }

}
