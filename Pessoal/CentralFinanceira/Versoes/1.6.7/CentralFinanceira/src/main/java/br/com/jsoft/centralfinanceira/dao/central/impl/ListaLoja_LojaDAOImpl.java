package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.ListaLoja_LojaDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ListaLoja;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ListaLoja_Loja;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ListaLoja_LojaDAOImpl extends BaseDAOImpl<ListaLoja_Loja> implements ListaLoja_LojaDAO {

    @Override
    public Class getEntityClass() {
        return ListaLoja.class;
    }

}
