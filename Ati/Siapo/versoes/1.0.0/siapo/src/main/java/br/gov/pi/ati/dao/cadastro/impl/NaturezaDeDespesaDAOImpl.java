package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.NaturezaDeDespesaDAO;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeDespesa;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class NaturezaDeDespesaDAOImpl extends BaseDAOImpl<NaturezaDeDespesa> implements NaturezaDeDespesaDAO {

    @Override
    public Class getEntityClass() {
        return NaturezaDeDespesa.class;
    }

}
