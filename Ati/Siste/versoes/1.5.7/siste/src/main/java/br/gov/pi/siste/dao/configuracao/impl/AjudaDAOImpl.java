package br.gov.pi.siste.dao.configuracao.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.configuracao.AjudaDAO;
import br.gov.pi.siste.modelo.configuracao.Ajuda;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class AjudaDAOImpl extends BaseDAOImpl<Ajuda> implements AjudaDAO {

    @Override
    public Class getEntityClass() {
        return Ajuda.class;
    }

}
