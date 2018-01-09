package br.gov.pi.ati.agendacultural.dao.cadastro.impl;

import br.gov.pi.ati.agendacultural.application.BaseDAOImpl;
import br.gov.pi.ati.agendacultural.dao.cadastro.TipoLocalDAO;
import br.gov.pi.ati.agendacultural.modelo.cadastro.TipoLocal;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TipoLocalDAOImpl extends BaseDAOImpl<TipoLocal> implements TipoLocalDAO {

    @Override
    public Class getEntityClass() {
        return TipoLocal.class;
    }

}
