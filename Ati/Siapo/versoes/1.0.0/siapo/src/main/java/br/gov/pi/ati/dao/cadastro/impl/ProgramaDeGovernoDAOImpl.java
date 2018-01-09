package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.ProgramaDeGovernoDAO;
import br.gov.pi.ati.modelo.cadastro.ProgramaDeGoverno;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ProgramaDeGovernoDAOImpl extends BaseDAOImpl<ProgramaDeGoverno> implements ProgramaDeGovernoDAO {

    @Override
    public Class getEntityClass() {
        return ProgramaDeGoverno.class;
    }

}
