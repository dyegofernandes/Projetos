package br.gov.pi.siste.dao.financeiro.impl;

import br.gov.pi.siste.application.BaseDAOImpl;
import br.gov.pi.siste.dao.financeiro.FontePagadorDAO;
import br.gov.pi.siste.modelo.financeiro.FontePagador;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class FontePagadorDAOImpl extends BaseDAOImpl<FontePagador> implements FontePagadorDAO {

    @Override
    public Class getEntityClass() {
        return FontePagador.class;
    }

}
