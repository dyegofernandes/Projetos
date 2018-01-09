package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.DrogaOcorrenciaItemDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.DrogaOcorrenciaItem;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DrogaOcorrenciaItemDAOImpl extends BaseDAOImpl<DrogaOcorrenciaItem> implements DrogaOcorrenciaItemDAO {

    @Override
    public Class getEntityClass() {
        return DrogaOcorrenciaItem.class;
    }

}
