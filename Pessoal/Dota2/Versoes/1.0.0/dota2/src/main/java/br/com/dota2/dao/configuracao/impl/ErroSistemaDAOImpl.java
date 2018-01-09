package br.com.dota2.dao.configuracao.impl;

import br.com.dota2.application.BaseDAOImpl;
import br.com.dota2.dao.configuracao.ErroSistemaDAO;
import br.com.dota2.modelo.configuracao.ErroSistema;
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
