package br.com.jsoft.centralfinanceira.dao.central.impl;

import br.com.jsoft.centralfinanceira.application.BaseDAOImpl;
import br.com.jsoft.centralfinanceira.dao.central.ComissaoCreditoGrupoLojaDAO;
import br.com.jsoft.centralfinanceira.modelo.cadastroBasicos.ComissaoCreditoGrupoLoja;
import javax.ejb.Stateless;

/**
 *
 * @author Juniel
 */
@Stateless
public class ComissaoCreditoGrupoLojaDAOImpl extends BaseDAOImpl<ComissaoCreditoGrupoLoja> implements ComissaoCreditoGrupoLojaDAO {

    @Override
    public Class getEntityClass() {
        return ComissaoCreditoGrupoLoja.class;
    }

}
