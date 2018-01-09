package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.GuarnicaoViaturaDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.GuarnicaoViatura;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class GuarnicaoViaturaDAOImpl extends BaseDAOImpl<GuarnicaoViatura> implements GuarnicaoViaturaDAO {

    @Override
    public Class getEntityClass() {
        return GuarnicaoViatura.class;
    }

}
