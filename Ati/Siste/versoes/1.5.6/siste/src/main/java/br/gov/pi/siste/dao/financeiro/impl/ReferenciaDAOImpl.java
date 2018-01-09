package br.gov.pi.siste.dao.financeiro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.financeiro.ReferenciaDAO;
import br.gov.pi.siste.modelo.financeiro.Referencia;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ReferenciaDAOImpl extends BaseDAOImpl<Referencia> implements ReferenciaDAO {

    @Override
    public Class getEntityClass() {
        return Referencia.class;
    }

}
