package br.com.ejccard.dao.financeiro.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.financeiro.CaixaDAO;
import br.com.ejccard.modelo.financeiro.Caixa;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class CaixaDAOImpl extends BaseDAOImpl<Caixa> implements CaixaDAO {

    @Override
    public Class getEntityClass() {
        return Caixa.class;
    }

}
