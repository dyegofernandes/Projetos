package br.gov.pi.ati.dao.orcamento.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.orcamento.MetaPPADAO;
import br.gov.pi.ati.modelo.orcamento.MetaPPA;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MetaPPADAOImpl extends BaseDAOImpl<MetaPPA> implements MetaPPADAO {

    @Override
    public Class getEntityClass() {
        return MetaPPA.class;
    }

}
