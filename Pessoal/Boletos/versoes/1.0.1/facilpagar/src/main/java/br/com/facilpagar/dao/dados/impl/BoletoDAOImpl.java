package br.com.facilpagar.dao.dados.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.dados.BoletoDAO;
import br.com.facilpagar.modelo.dados.Boleto;
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
