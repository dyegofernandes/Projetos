package br.gov.pi.ati.sisrh.dao.cadastro;


import br.gov.pi.ati.sisrh.application.BaseDAOImpl;
import br.gov.pi.ati.sisrh.modelo.cadastro.FichaDeVisitaDomiciliar;
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
