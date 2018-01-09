package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.LocalIntermediarioDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.LocalIntermediario;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class LocalIntermediarioDAOImpl extends BaseDAOImpl<LocalIntermediario> implements LocalIntermediarioDAO {

    @Override
    public Class getEntityClass() {
        return LocalIntermediario.class;
    }

}
