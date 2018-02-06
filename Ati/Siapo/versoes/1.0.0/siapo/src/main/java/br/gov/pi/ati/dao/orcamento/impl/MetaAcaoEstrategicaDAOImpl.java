package br.gov.pi.ati.dao.orcamento.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.orcamento.MetaAcaoEstrategicaDAO;
import br.gov.pi.ati.modelo.orcamento.MetaAcaoEstrategica;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class MetaAcaoEstrategicaDAOImpl extends BaseDAOImpl<MetaAcaoEstrategica> implements MetaAcaoEstrategicaDAO {

    @Override
    public Class getEntityClass() {
        return MetaAcaoEstrategica.class;
    }

}
