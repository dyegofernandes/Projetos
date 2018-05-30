package br.gov.pi.ati.dao.orcamento.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.orcamento.DespesaPublicaDAO;
import br.gov.pi.ati.modelo.orcamento.DespesaPublica;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class DespesaPublicaDAOImpl extends BaseDAOImpl<DespesaPublica> implements DespesaPublicaDAO {

    @Override
    public Class getEntityClass() {
        return DespesaPublica.class;
    }

}
