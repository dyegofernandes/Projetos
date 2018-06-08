package br.com.facilpagar.dao.configuracao.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.configuracao.ErroSistemaDAO;
import br.com.facilpagar.modelo.configuracao.ErroSistema;
import javax.ejb.Stateless;

/**
 *
 * @author Ayslan
 */
@Stateless
public class ErroSistemaDAOImpl extends BaseDAOImpl<ErroSistema> implements ErroSistemaDAO {

    @Override
    public Class getEntityClass() {
        return ErroSistema.class;
    }
    
    
    
}
