package br.com.dizimo.dao.cadastro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.cadastro.BairroDAO;
import br.com.dizimo.modelo.cadastro.Bairro;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class BairroDAOImpl extends BaseDAOImpl<Bairro> implements BairroDAO {

    @Override
    public Class getEntityClass() {
        return Bairro.class;
    }

}
