package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.ProgramaPPADAO;
import br.gov.pi.ati.modelo.cadastro.ProgramaPPA;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProgramaPPADAOImpl extends BaseDAOImpl<ProgramaPPA> implements ProgramaPPADAO {

    @Override
    public Class getEntityClass() {
        return ProgramaPPA.class;
    }

}
