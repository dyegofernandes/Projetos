package br.com.dota2.dao.controleacesso.impl;

import br.com.dota2.application.BaseDAOImpl;
import br.com.dota2.dao.controleacesso.AcessoSistemaDAO;
import br.com.dota2.modelo.controleacesso.AcessoSistema;
import javax.ejb.Stateless;

/**
 *
 * @author ayslan
 */
@Stateless
public class AcessoSistemaDAOImpl extends BaseDAOImpl<AcessoSistema> implements AcessoSistemaDAO {

    @Override
    public Class getEntityClass() {
        return AcessoSistema.class;
    }
    
    
}
