package br.com.dizimo.dao.financeiro.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.financeiro.CaixaDAO;
import br.com.dizimo.modelo.financeiro.Caixa;
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
