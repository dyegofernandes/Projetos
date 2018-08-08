package br.com.dizimo.dao.controleacesso.impl;

import br.com.dizimo.application.BaseDAOImpl;
import br.com.dizimo.dao.controleacesso.AcessoSistemaDAO;
import br.com.dizimo.modelo.controleacesso.AcessoSistema;
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
