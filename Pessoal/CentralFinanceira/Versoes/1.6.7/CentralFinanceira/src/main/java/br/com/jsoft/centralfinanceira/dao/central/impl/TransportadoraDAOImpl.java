package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.TransportadoraDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Transportadora;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class TransportadoraDAOImpl extends BaseDAOImpl<Transportadora> implements TransportadoraDAO {

    @Override
    public Class getEntityClass() {
        return Transportadora.class;
    }

}
