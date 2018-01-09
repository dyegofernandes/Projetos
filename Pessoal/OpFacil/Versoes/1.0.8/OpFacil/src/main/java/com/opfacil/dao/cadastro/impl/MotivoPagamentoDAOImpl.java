package com.opfacil.dao.cadastro.impl;

import com.opfacil.application.BaseDAOImpl;
import com.opfacil.dao.cadastro.MotivoPagamentoDAO;
import com.opfacil.modelo.cadastro.MotivoPagamento;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class MotivoPagamentoDAOImpl extends BaseDAOImpl<MotivoPagamento> implements MotivoPagamentoDAO {

    @Override
    public Class getEntityClass() {
        return MotivoPagamento.class;
    }

}
