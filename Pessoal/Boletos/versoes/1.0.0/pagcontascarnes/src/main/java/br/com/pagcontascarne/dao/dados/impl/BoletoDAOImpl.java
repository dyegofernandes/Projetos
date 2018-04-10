package br.com.pagcontascarne.dao.dados.impl;

import br.com.pagcontascarne.application.BaseDAOImpl;
import br.com.pagcontascarne.dao.dados.BoletoDAO;
import br.com.pagcontascarne.modelo.dados.Boleto;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class BoletoDAOImpl extends BaseDAOImpl<Boleto> implements BoletoDAO {

    @Override
    public Class getEntityClass() {
        return Boleto.class;
    }

}
