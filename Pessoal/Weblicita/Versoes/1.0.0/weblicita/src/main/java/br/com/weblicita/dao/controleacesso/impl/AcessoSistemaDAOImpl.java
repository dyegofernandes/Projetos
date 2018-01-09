package br.com.weblicita.dao.controleacesso.impl;

import br.com.weblicita.application.BaseDAOImpl;
import br.com.weblicita.dao.controleacesso.AcessoSistemaDAO;
import br.com.weblicita.modelo.controleacesso.AcessoSistema;
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
