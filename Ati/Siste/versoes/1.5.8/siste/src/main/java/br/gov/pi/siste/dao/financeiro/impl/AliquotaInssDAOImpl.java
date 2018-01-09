package br.gov.pi.siste.dao.financeiro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.financeiro.AliquotaInssDAO;
import br.gov.pi.siste.modelo.financeiro.AliquotaInss;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AliquotaInssDAOImpl extends BaseDAOImpl<AliquotaInss> implements AliquotaInssDAO {

    @Override
    public Class getEntityClass() {
        return AliquotaInss.class;
    }

}
