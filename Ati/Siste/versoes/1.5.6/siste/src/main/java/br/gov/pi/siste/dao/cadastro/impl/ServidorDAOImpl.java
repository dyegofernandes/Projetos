package br.gov.pi.siste.dao.cadastro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.cadastro.ServidorDAO;
import br.gov.pi.siste.modelo.cadastro.Servidor;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ServidorDAOImpl extends BaseDAOImpl<Servidor> implements ServidorDAO {

    @Override
    public Class getEntityClass() {
        return Servidor.class;
    }

}
