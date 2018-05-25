package br.gov.pi.ati.sisrh.dao.cadastro;

import br.gov.pi.ati.sisrh.application.BaseDAOImpl;
import br.gov.pi.ati.sisrh.modelo.cadastro.FichaDeVisitaInstitucionalLGBT;
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
