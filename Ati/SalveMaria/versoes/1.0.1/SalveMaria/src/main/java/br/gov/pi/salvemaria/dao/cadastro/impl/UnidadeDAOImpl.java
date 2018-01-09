package br.gov.pi.salvemaria.dao.cadastro.impl;

import br.gov.pi.salvemaria.application.BaseDAOImpl;
import br.gov.pi.salvemaria.dao.cadastro.UnidadeDAO;
import br.gov.pi.salvemaria.modelo.cadastro.Unidade;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class UnidadeDAOImpl extends BaseDAOImpl<Unidade> implements UnidadeDAO {

    @Override
    public Class getEntityClass() {
        return Unidade.class;
    }

}
