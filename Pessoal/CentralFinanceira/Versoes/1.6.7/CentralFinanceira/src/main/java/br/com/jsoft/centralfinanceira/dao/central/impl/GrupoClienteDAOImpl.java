package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.GrupoClienteDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoCliente;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class GrupoClienteDAOImpl extends BaseDAOImpl<GrupoCliente> implements GrupoClienteDAO {

    @Override
    public Class getEntityClass() {
        return GrupoCliente.class;
    }

}
