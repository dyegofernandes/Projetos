package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.GrupoLojaDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.GrupoLoja;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class GrupoLojaDAOImpl extends BaseDAOImpl<GrupoLoja> implements GrupoLojaDAO {

    @Override
    public Class getEntityClass() {
        return GrupoLoja.class;
    }

}
