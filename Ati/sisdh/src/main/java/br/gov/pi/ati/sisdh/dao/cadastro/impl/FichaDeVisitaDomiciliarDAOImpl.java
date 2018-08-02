package br.gov.pi.ati.sisdh.dao.cadastro.impl;


import br.gov.pi.ati.sisdh.application.BaseDAOImpl;
import br.gov.pi.ati.sisdh.dao.cadastro.FichaDeVisitaDomiciliarDAO;
import br.gov.pi.ati.sisdh.modelo.cadastro.FichaDeVisitaDomiciliar;
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
