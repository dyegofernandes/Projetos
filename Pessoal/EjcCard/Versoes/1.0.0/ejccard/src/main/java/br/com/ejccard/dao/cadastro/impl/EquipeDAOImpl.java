package br.com.ejccard.dao.cadastro.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.cadastro.EquipeDAO;
import br.com.ejccard.modelo.cadastro.Equipe;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class EquipeDAOImpl extends BaseDAOImpl<Equipe> implements EquipeDAO {

    @Override
    public Class getEntityClass() {
        return Equipe.class;
    }

}
