package br.gov.pi.ati.dao.cadastro.impl;

import br.gov.pi.ati.application.BaseDAOImpl;
import br.gov.pi.ati.dao.cadastro.NaturezaDeReceitaDAO;
import br.gov.pi.ati.modelo.cadastro.NaturezaDeReceita;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class NaturezaDeReceitaDAOImpl extends BaseDAOImpl<NaturezaDeReceita> implements NaturezaDeReceitaDAO {

    @Override
    public Class getEntityClass() {
        return NaturezaDeReceita.class;
    }

}
