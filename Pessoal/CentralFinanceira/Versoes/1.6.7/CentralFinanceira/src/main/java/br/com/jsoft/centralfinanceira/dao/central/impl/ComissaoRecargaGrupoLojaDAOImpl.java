package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.ComissaoRecargaGrupoLojaDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ComissaoRecargaGrupoLoja;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ComissaoRecargaGrupoLojaDAOImpl extends BaseDAOImpl<ComissaoRecargaGrupoLoja> implements ComissaoRecargaGrupoLojaDAO {

    @Override
    public Class getEntityClass() {
        return ComissaoRecargaGrupoLoja.class;
    }

}
