package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.FichaDeVisitaInstitucionalLGBTDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.FichaDeVisitaInstitucionalLGBT;
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
