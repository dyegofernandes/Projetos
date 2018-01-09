package br.gov.pi.siste.dao.financeiro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.financeiro.AliquotaIRRFDAO;
import br.gov.pi.siste.modelo.financeiro.AliquotaIRRF;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AliquotaIRRFDAOImpl extends BaseDAOImpl<AliquotaIRRF> implements AliquotaIRRFDAO {

    @Override
    public Class getEntityClass() {
        return AliquotaIRRF.class;
    }

}
