package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.GrupoReceitaDespesaDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoReceitaDespesa;
import javax.ejb.Stateless;

/**
 *
 * @author KillerBeeTwo
 */
@Stateless
public class GrupoReceitaDespesaDAOImpl extends BaseDAOImpl<GrupoReceitaDespesa> implements GrupoReceitaDespesaDAO {

    @Override
    public Class getEntityClass() {
        return GrupoReceitaDespesa.class;
    }

}
