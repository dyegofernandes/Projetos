package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.CompentenciaPPADAO;
import br.gov.pi.ati.modelo.cadastro.CompentenciaPPA;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CompentenciaPPADAOImpl extends BaseDAOImpl<CompentenciaPPA> implements CompentenciaPPADAO {

    @Override
    public Class getEntityClass() {
        return CompentenciaPPA.class;
    }

}
