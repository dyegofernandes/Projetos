package com.ebol.dao.cadastro.impl;

import com.ebol.application.BaseDAOImpl;
import com.ebol.dao.cadastro.Padrao_CobrancaDAO;
import com.ebol.modelo.cadastro.Padrao_Cobranca;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class Padrao_CobrancaDAOImpl extends BaseDAOImpl<Padrao_Cobranca> implements Padrao_CobrancaDAO {

    @Override
    public Class getEntityClass() {
        return Padrao_Cobranca.class;
    }

}
