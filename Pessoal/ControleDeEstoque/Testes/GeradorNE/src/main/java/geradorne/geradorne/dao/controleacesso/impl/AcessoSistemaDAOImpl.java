package geradorne.geradorne.dao.controleacesso.impl;

import geradorne.geradorne.application.BaseDAOImpl;
import geradorne.geradorne.dao.controleacesso.AcessoSistemaDAO;
import geradorne.geradorne.modelo.controleacesso.AcessoSistema;
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
