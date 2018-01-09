package br.gov.pi.ati.sisforms.dao.servicos.impl;

import br.gov.pi.ati.sisforms.application.BaseDAOImpl;
import br.gov.pi.ati.sisforms.dao.servicos.ReservaLocalDAO;
import br.gov.pi.ati.sisforms.modelo.servicos.ReservaLocal;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ReservaLocalDAOImpl extends BaseDAOImpl<ReservaLocal> implements ReservaLocalDAO {

    @Override
    public Class getEntityClass() {
        return ReservaLocal.class;
    }

}
