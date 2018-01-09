package br.gov.pi.ati.sisforms.dao.formulario.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.formulario.FichaDeVisitaDomiciliarDAO;
import br.gov.pi.ati.sisforms.modelo.formulario.FichaDeVisitaDomiciliar;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FichaDeVisitaDomiciliarDAOImpl extends BaseDAOImpl<FichaDeVisitaDomiciliar> implements FichaDeVisitaDomiciliarDAO {

    @Override
    public Class getEntityClass() {
        return FichaDeVisitaDomiciliar.class;
    }

}
