package br.gov.pi.ati.siopm.dao.cadastro.impl;

import br.gov.pi.ati.siopm.application.BaseDAOImpl;
import br.gov.pi.ati.siopm.dao.cadastro.LogradouroDAO;
import br.gov.pi.ati.siopm.modelo.cadastro.Logradouro;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class LogradouroDAOImpl extends BaseDAOImpl<Logradouro> implements LogradouroDAO {

    @Override
    public Class getEntityClass() {
        return Logradouro.class;
    }

}
