package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.BancoDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Banco;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class BancoDAOImpl extends BaseDAOImpl<Banco> implements BancoDAO {

    @Override
    public Class getEntityClass() {
        return Banco.class;
    }

}
