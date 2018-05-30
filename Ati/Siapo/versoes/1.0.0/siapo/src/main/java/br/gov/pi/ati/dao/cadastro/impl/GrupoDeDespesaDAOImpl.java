package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.GrupoDeDespesaDAO;
import br.gov.pi.ati.modelo.cadastro.GrupoDeDespesa;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoDeDespesaDAOImpl extends BaseDAOImpl<GrupoDeDespesa> implements GrupoDeDespesaDAO {

    @Override
    public Class getEntityClass() {
        return GrupoDeDespesa.class;
    }

}
