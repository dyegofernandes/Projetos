package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.BancoDAO;
import br.com.facilpagar.modelo.dados.Banco;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class BancoDAOImpl extends BaseDAOImpl<Banco> implements BancoDAO {

    @Override
    public Class getEntityClass() {
        return Banco.class;
    }

}
