package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.CategoriaDeDespesaDAO;
import br.gov.pi.ati.modelo.cadastro.CategoriaDeDespesa;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CategoriaDeDespesaDAOImpl extends BaseDAOImpl<CategoriaDeDespesa> implements CategoriaDeDespesaDAO {

    @Override
    public Class getEntityClass() {
        return CategoriaDeDespesa.class;
    }

}
