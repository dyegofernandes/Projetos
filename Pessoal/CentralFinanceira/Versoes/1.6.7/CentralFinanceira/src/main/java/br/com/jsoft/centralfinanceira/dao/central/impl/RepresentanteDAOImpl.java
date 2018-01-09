package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.RepresentanteDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.Representante;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class RepresentanteDAOImpl extends BaseDAOImpl<Representante> implements RepresentanteDAO {

    @Override
    public Class getEntityClass() {
        return Representante.class;
    }

}
