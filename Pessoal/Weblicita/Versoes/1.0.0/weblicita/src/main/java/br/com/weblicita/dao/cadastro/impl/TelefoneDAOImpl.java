package br.com.weblicita.dao.cadastro.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.cadastro.TelefoneDAO;
import br.com.weblicita.modelo.cadastro.Telefone;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class TelefoneDAOImpl extends BaseDAOImpl<Telefone> implements TelefoneDAO {

    @Override
    public Class getEntityClass() {
        return Telefone.class;
    }

}
