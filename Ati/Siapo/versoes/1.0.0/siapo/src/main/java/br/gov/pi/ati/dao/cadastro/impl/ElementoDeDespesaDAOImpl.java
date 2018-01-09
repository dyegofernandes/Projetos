package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.ElementoDeDespesaDAO;
import br.gov.pi.ati.modelo.cadastro.ElementoDeDespesa;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ElementoDeDespesaDAOImpl extends BaseDAOImpl<ElementoDeDespesa> implements ElementoDeDespesaDAO {

    @Override
    public Class getEntityClass() {
        return ElementoDeDespesa.class;
    }

}
