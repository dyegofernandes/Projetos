package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.ComissaoBBGrupoLojaDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ComissaoBBGrupoLoja;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ComissaoBBGrupoLojaDAOImpl extends BaseDAOImpl<ComissaoBBGrupoLoja> implements ComissaoBBGrupoLojaDAO {

    @Override
    public Class getEntityClass() {
        return ComissaoBBGrupoLoja.class;
    }

}
