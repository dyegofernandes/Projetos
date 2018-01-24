package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.MunicipioDAO;
import br.gov.pi.ati.modelo.cadastro.Municipio;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MunicipioDAOImpl extends BaseDAOImpl<Municipio> implements MunicipioDAO {

    @Override
    public Class getEntityClass() {
        return Municipio.class;
    }

}
