package br.gov.pi.ati.sisdh.dao.cadastro.impl;

import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.FichaDeVisitaInstitucionalLGBTDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.FichaDeVisitaInstitucionalLGBT;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FichaDeVisitaInstitucionalLGBTDAOImpl extends BaseDAOImpl<FichaDeVisitaInstitucionalLGBT> implements FichaDeVisitaInstitucionalLGBTDAO {

    @Override
    public Class getEntityClass() {
        return FichaDeVisitaInstitucionalLGBT.class;
    }

}
