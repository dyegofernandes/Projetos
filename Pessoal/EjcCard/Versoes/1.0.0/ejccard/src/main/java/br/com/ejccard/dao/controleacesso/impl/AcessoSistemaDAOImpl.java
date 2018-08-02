package br.com.ejccard.dao.controleacesso.impl;

import br.com.ejccard.application.BaseDAOImpl;
import br.com.ejccard.dao.controleacesso.AcessoSistemaDAO;
import br.com.ejccard.modelo.controleacesso.AcessoSistema;
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
