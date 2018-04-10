package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.BancoDAO;
import br.com.pagcontascarne.modelo.dados.Banco;
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
