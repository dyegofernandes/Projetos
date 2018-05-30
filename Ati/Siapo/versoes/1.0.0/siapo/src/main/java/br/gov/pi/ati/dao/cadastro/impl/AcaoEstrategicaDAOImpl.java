package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.AcaoEstrategicaDAO;
import br.gov.pi.ati.modelo.cadastro.AcaoEstrategica;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AcaoEstrategicaDAOImpl extends BaseDAOImpl<AcaoEstrategica> implements AcaoEstrategicaDAO {

    @Override
    public Class getEntityClass() {
        return AcaoEstrategica.class;
    }

}
