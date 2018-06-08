package br.com.facilpagar.dao.controleacesso.impl;

import br.com.facilpagar.application.BaseDAOImpl;
import br.com.facilpagar.dao.controleacesso.AcessoSistemaDAO;
import br.com.facilpagar.modelo.controleacesso.AcessoSistema;
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
